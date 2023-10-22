package com.cardif.tsp.websso;

import com.cardif.tsp.websso.domain.CredentialsItem;
import com.cardif.tsp.websso.domain.User;
import com.cardif.tsp.websso.domain.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> arguments = Arrays.stream(args).collect(Collectors.toList());
        if(arguments.isEmpty()){
            throw new RuntimeException("Insert the users file location please!");
        }
        String fileLocation = arguments.get(0);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileLocation);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            final List<Integer> notTheseRows = new ArrayList<>();
            notTheseRows.add(0);
            notTheseRows.add(1);
            notTheseRows.add(2);
            Users users = new Users();
            User user = new User();

            for (Row row : sheet) {
                //row.getCell(0).


                if(!notTheseRows.contains(row.getRowNum())){
                    if(!StringUtils.isEmpty(row.getCell(0).getStringCellValue())){
                        User.UserBuilder builder = User.builder();
                        builder.username(row.getCell(0).getStringCellValue());
                        builder.enabled(row.getCell(1).getBooleanCellValue());
                        builder.totp(row.getCell(2).getBooleanCellValue());
                        builder.emailVerified(row.getCell(3).getBooleanCellValue());
                        builder.firstName(row.getCell(4).getStringCellValue());
                        builder.lastName(row.getCell(5).getStringCellValue());
                        builder.email(row.getCell(6).getStringCellValue());
                        //builder.notBefore(row.getCell(9).geti)
                        CredentialsItem.CredentialsItemBuilder credentialsItemBuilder = CredentialsItem.builder();
                        credentialsItemBuilder.type(row.getCell(10).getStringCellValue());
                        credentialsItemBuilder.hashedSaltedValue(row.getCell(11).getStringCellValue());
                        credentialsItemBuilder.salt(row.getCell(12).getStringCellValue());
                        //credentialsItemBuilder.hashIterations(Integer.parseInt(row.getCell(13).getStringCellValue()));
                        credentialsItemBuilder.algorithm(row.getCell(14).getStringCellValue());
                        List<CredentialsItem> credentialsItems = new ArrayList<>();
                        credentialsItems.add(CredentialsItem.builder().build());
                        builder.credentials(credentialsItems);
                        List<String> realmRoles = Arrays.stream(row.getCell(15).getStringCellValue().split(","))
                                .map(String::trim).collect(Collectors.toList());
                        builder.realmRoles(realmRoles);
                        user = builder.build();
                        users.addUser(user);
                    }
                }
            }
            File file = new File("users.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

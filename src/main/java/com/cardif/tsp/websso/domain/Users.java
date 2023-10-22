package com.cardif.tsp.websso.domain;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class Users {

	@JsonProperty("users")
	private List<User> users;

	public Users() {
		this.users = new ArrayList<>();
	}

	public void addUser(User user){
		users.add(user);
	}
}

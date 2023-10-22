package com.cardif.tsp.websso.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersItem{

	@JsonProperty("users")
	private List<UsersItem> users;

	@JsonProperty("disableableCredentialTypes")
	private List<Object> disableableCredentialTypes;

	@JsonProperty("totp")
	private boolean totp;

	@JsonProperty("emailVerified")
	private boolean emailVerified;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("realmRoles")
	private List<String> realmRoles;

	@JsonProperty("requiredActions")
	private List<Object> requiredActions;

	@JsonProperty("credentials")
	private List<CredentialsItem> credentials;

	@JsonProperty("enabled")
	private boolean enabled;

	@JsonProperty("email")
	private String email;

	@JsonProperty("notBefore")
	private int notBefore;

	@JsonProperty("username")
	private String username;
}

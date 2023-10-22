package com.cardif.tsp.websso.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {


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

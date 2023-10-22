package com.cardif.tsp.websso.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialsItem{

	@JsonProperty("hashedSaltedValue")
	private String hashedSaltedValue;

	@JsonProperty("salt")
	private String salt;

	@JsonProperty("hashIterations")
	private int hashIterations;

	@JsonProperty("type")
	private String type;

	@JsonProperty("algorithm")
	private String algorithm;
}

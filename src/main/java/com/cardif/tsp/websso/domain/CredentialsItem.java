package com.cardif.tsp.websso.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public String getHashedSaltedValue(){
		return hashedSaltedValue;
	}

	public String getSalt(){
		return salt;
	}

	public int getHashIterations(){
		return hashIterations;
	}

	public String getType(){
		return type;
	}

	public String getAlgorithm(){
		return algorithm;
	}
}

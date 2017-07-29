package com.angelhack.mapteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileResponse{

	@JsonProperty("age_range")
	private AgeRange ageRange;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("locale")
	private String locale;

	@JsonProperty("email")
	private String email;

	public void setAgeRange(AgeRange ageRange){
		this.ageRange = ageRange;
	}

	public AgeRange getAgeRange(){
		return ageRange;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ProfileResponse{" + 
			"age_range = '" + ageRange + '\'' + 
			",gender = '" + gender + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",locale = '" + locale + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
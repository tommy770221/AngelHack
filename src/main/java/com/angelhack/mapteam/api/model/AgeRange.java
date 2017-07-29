package com.angelhack.mapteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgeRange{

	@JsonProperty("min")
	private int min;

	public void setMin(int min){
		this.min = min;
	}

	public int getMin(){
		return min;
	}

	@Override
 	public String toString(){
		return 
			"AgeRange{" + 
			"min = '" + min + '\'' + 
			"}";
		}
}
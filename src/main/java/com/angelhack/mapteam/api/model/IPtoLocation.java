package com.angelhack.mapteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IPtoLocation{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("org")
	private String org;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("isp")
	private String isp;

	@JsonProperty("query")
	private String query;

	@JsonProperty("regionName")
	private String regionName;

	@JsonProperty("lon")
	private Double lon;

	@JsonProperty("as")
	private String as;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("region")
	private String region;

	@JsonProperty("lat")
	private Double lat;

	@JsonProperty("status")
	private String status;

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getZip(){
		return zip;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setOrg(String org){
		this.org = org;
	}

	public String getOrg(){
		return org;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setIsp(String isp){
		this.isp = isp;
	}

	public String getIsp(){
		return isp;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setRegionName(String regionName){
		this.regionName = regionName;
	}

	public String getRegionName(){
		return regionName;
	}



	public void setAs(String as){
		this.as = as;
	}

	public String getAs(){
		return as;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}


	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"IPtoLocation{" + 
			"zip = '" + zip + '\'' + 
			",country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",org = '" + org + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",isp = '" + isp + '\'' + 
			",query = '" + query + '\'' + 
			",regionName = '" + regionName + '\'' + 
			",lon = '" + lon + '\'' + 
			",as = '" + as + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",region = '" + region + '\'' + 
			",lat = '" + lat + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
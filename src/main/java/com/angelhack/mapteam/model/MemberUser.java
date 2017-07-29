package com.angelhack.mapteam.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBERUSER")
public class MemberUser {

    @Id
    @JsonProperty("id")
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    @JsonProperty("gender")
    private String gender;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("locale")
    private String locale;

    @Column
    @JsonProperty("email")
    private String email;

    @Column
    @JsonProperty("ageRange")
    private String ageRange;

    @Column
    @JsonProperty("fbId")
    private String fbId;

    @Column
    @JsonProperty("lon")
    private Double lon;

    @Column
    @JsonProperty("lat")
    private Double lat;

    @Column
    @JsonProperty("updateDate")
    private Date updateDate;

    @Transient
    @JsonProperty
    private Double distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

}

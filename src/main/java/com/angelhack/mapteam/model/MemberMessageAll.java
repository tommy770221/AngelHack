package com.angelhack.mapteam.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBERMESSAGEAll")
public class MemberMessageAll {

    @Id
    @JsonProperty("id")
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    @JsonProperty
    private String fromEmail;

    @Column
    @JsonProperty
    private String message;

    @Column
    @JsonProperty("lon")
    private Double lon;

    @Column
    @JsonProperty("lat")
    private Double lat;

    @Transient
    @JsonProperty
    private Double distance;

    @Column
    @JsonProperty
    private Date createDate;

    @Column
    @JsonProperty
    private Boolean getRead;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getGetRead() {
        return getRead;
    }

    public void setGetRead(Boolean getRead) {
        this.getRead = getRead;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}

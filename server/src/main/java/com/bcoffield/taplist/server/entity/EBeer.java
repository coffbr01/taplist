package com.bcoffield.taplist.server.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=EBeer.FIND_ALL, query="select * from ebeer")
public class EBeer {
    public static final String FIND_ALL = "FIND_ALL";

    private String name;
    private String description;
    private Integer srm;
    private Float abv;
    private Float og;
    private Float fg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSrm() {
        return srm;
    }

    public void setSrm(Integer srm) {
        this.srm = srm;
    }

    public Float getAbv() {
        return abv;
    }

    public void setAbv(Float abv) {
        this.abv = abv;
    }

    public Float getOg() {
        return og;
    }

    public void setOg(Float og) {
        this.og = og;
    }

    public Float getFg() {
        return fg;
    }

    public void setFg(Float fg) {
        this.fg = fg;
    }
}
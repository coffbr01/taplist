package com.bcoffield.taplist.server.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=ESRMValue.FIND_ALL, query="SELECT * FROM esrmvalue")
public class ESRMValue {
    public static final String FIND_ALL = "FIND_ALL";
    private Integer srm;
    private String color;

    public Integer getSrm() {
        return srm;
    }

    public void setSrm(Integer srm) {
        this.srm = srm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package com.bcoffield.taplist.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DTOBeer {
    private Float abv;
    private String description;
    private Float fg;
    private String name;
    private Float og;
    private Integer srm;

    public void setAbv(Float abv) {
        this.abv = abv;
    }

    public Float getAbv() {
        return abv;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFg(Float fg) {
        this.fg = fg;
    }

    public Float getFg() {
        return fg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOg(Float og) {
        this.og = og;
    }

    public Float getOg() {
        return og;
    }

    public void setSrm(Integer srm) {
        this.srm = srm;
    }

    public Integer getSrm() {
        return srm;
    }
}

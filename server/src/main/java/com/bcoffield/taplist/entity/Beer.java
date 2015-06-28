package com.bcoffield.taplist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Beer")
@NamedQuery(name = Beer.FIND_ALL, query = "SELECT b FROM Beer b")
public class Beer {
    public static final String FIND_ALL = "Beer.findAll";

    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer srm;
    private Float abv;
    private Float og;
    private Float fg;

    public Beer() {};

    public Beer(Float abv, String description, Float fg, String name, Float og, Integer srm) {
        this.abv = abv;
        this.description = description;
        this.fg = fg;
        this.name = name;
        this.og = og;
        this.srm = srm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
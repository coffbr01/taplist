package com.bcoffield.taplist.entity;

import javax.persistence.*;

@Entity
@Table(name = "Beer")
public class Beer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Integer srm;
    private Float abv;
    private Float og;
    private Float fg;
    @ManyToOne
    private Dispenser dispenser;

    public Beer() {};

    public Beer(Integer id, Float abv, String description, Float fg, String name, Float og, Integer srm) {
        this.id = id;
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

    public Dispenser getDispenser() {
        return dispenser;
    }

    public void setDispenser(Dispenser dispenser) {
        this.dispenser = dispenser;
    }
}
package com.bcoffield.taplist.dto;

import java.awt.*;

public class DTOBeer {
    private String name;
    private String description;
    private DTOBeerStyle style;
    private Color srm;
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

    public DTOBeerStyle getStyle() {
        return style;
    }

    public void setStyle(DTOBeerStyle style) {
        this.style = style;
    }

    public Color getSrm() {
        return srm;
    }

    public void setSrm(Color srm) {
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

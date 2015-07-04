package com.bcoffield.taplist.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DTODispenser {
    private Integer id;
    private String name;
    private List<DTOBeer> beers;

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

    public List<DTOBeer> getBeers() {
        return beers;
    }

    public void setBeers(List<DTOBeer> beers) {
        this.beers = beers;
    }
}

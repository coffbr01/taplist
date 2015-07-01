package com.bcoffield.taplist.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DTOTapList {
    private List<DTOBeer> beers;

    public List<DTOBeer> getBeers() {
        return beers;
    }

    public void setBeers(List<DTOBeer> beers) {
        this.beers = beers;
    }
}

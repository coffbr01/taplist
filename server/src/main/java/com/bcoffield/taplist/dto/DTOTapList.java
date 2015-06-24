package com.bcoffield.taplist.dto;

import java.util.List;

public class DTOTapList {
    private List<DTOBeer> beers;

    public List<DTOBeer> getBeers() {
        return beers;
    }

    public void setBeers(List<DTOBeer> beers) {
        this.beers = beers;
    }
}

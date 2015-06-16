package com.bcoffield.taplist.dto;

public enum DTOBeerStyle {
    BLONDE("Blonde"),
    IPA("IPA"),
    STOUT("Stout"),
    WHEAT("Wheat");

    private final String name;

    DTOBeerStyle(String name) {
        this.name = name;
    }
}

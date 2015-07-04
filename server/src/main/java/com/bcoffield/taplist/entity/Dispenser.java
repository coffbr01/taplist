package com.bcoffield.taplist.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dispenser")
public class Dispenser {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "dispenser")
    private List<Beer> beers;

    public Dispenser() {}

    public Dispenser(Integer id, String name, List<Beer> beers) {
        this.id = id;
        this.name = name;
        this.beers = beers;
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

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}

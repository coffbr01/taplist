package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.factory.BeerDTOFactory;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.service.IBeerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class BeerController {
    private static final String PATH = "/beer";
    private final IBeerService beerService;

    public BeerController(IBeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    @ResponseBody
    public DTOBeer post(DTOBeer dtoBeer) {
        EBeer eBeer = beerService.createBeer(dtoBeer.getAbv(),
                dtoBeer.getDescription(),
                dtoBeer.getFg(),
                dtoBeer.getName(),
                dtoBeer.getOg(),
                dtoBeer.getSrm());
        return BeerDTOFactory.build(eBeer);
    }
}

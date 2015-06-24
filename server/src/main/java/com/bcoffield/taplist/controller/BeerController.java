package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.factory.BeerDTOFactory;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.service.IBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

public class BeerController {
    private static final String PATH = "/beer";

    @Inject
    private IBeerService beerService;

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

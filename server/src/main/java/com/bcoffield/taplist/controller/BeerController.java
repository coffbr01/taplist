package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.factory.BeerDTOFactory;
import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.service.IBeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/beer")
public class BeerController {
    @Inject
    private IBeerService beerService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public DTOBeer post(@ModelAttribute DTOBeer dtoBeer) {
        Beer beer = beerService.createBeer(dtoBeer.getAbv(),
                dtoBeer.getDescription(),
                dtoBeer.getFg(),
                dtoBeer.getName(),
                dtoBeer.getOg(),
                dtoBeer.getSrm());
        return BeerDTOFactory.build(beer);
    }
}

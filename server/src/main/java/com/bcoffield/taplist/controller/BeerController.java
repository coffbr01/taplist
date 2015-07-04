package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.factory.BeerDTOFactory;
import com.bcoffield.taplist.dto.factory.IBeerDTOFactory;
import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.service.IBeerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("beer")
public class BeerController {
    @Inject
    private IBeerService beerService;
    @Inject
    private IBeerDTOFactory beerDTOFactory;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public DTOBeer post(@RequestBody DTOBeer dtoBeer) {
        Beer beer = beerService.create(dtoBeer.getAbv(),
                dtoBeer.getDescription(),
                dtoBeer.getFg(),
                dtoBeer.getName(),
                dtoBeer.getOg(),
                dtoBeer.getSrm());
        return beerDTOFactory.build(beer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public DTOBeer get(@PathVariable("id") Integer id) {
        Beer beer = beerService.findOne(id);
        return beerDTOFactory.build(beer);
    }

    @RequestMapping(value = "{id}/dispenser/{dispenserId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public DTOBeer addBeer(@PathVariable("id") Integer id, @PathVariable("dispenserId") Integer dispenserId) {
        Beer beer = beerService.setDispenser(id, dispenserId);
        return beerDTOFactory.build(beer);
    }
}

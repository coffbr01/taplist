package com.bcoffield.taplist.server.rest;

import com.bcoffield.taplist.server.dto.DTOBeer;
import com.bcoffield.taplist.server.dto.factory.BeerDTOFactory;
import com.bcoffield.taplist.server.entity.EBeer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("beer")
public class RSBeer {
    @POST
    public DTOBeer post(DTOBeer dtoBeer) {
        EBeer eBeer = beerMgmt.createBeer(dtoBeer.getAbv(),
                dtoBeer.getDescription(),
                dtoBeer.getFg(),
                dtoBeer.getName(),
                dtoBeer.getOg(),
                dtoBeer.getSrm());
        return BeerDTOFactory.build(eBeer);
    }
}

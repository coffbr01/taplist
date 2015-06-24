package com.bcoffield.taplist.rest;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.server.dtofactory.BeerDTOFactory;
import com.bcoffield.taplist.server.mgmt.BeerMgmt;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("beer")
public class RSBeer {
    @Inject
    private BeerMgmt beerMgmt;

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

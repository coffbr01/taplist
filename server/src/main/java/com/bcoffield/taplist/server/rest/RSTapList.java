package com.bcoffield.taplist.server.rest;

import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.server.mgmt.TapListMgmt;
import com.bcoffield.taplist.server.dtofactory.TapListDTOFactory;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("taplist")
public class RSTapList {
    @Inject
    private TapListMgmt tapListMgmt;

    @Inject
    private TapListDTOFactory tapListDTOFactory;

    public DTOTapList get(@DefaultValue("4") @QueryParam("count") Integer count) {
        List<EBeer> tapList = tapListMgmt.getTapList(count);
        return tapListDTOFactory.build(tapList);
    }
}

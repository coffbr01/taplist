package com.bcoffield.taplist.rest;

import com.bcoffield.taplist.api.IRSTapList;
import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.server.mgmt.TapListMgmt;
import com.bcoffield.taplist.server.dtofactory.TapListDTOFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RSTapList implements IRSTapList {
    @Inject
    private TapListMgmt tapListMgmt;

    @Inject
    private TapListDTOFactory tapListDTOFactory;

    public DTOTapList get(Integer count) {
        List<EBeer> tapList = tapListMgmt.getTapList(count);
        return tapListDTOFactory.build(tapList);
    }
}

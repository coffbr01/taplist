package com.bcoffield.taplist.server.dtofactory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.server.util.SRMUtil;

public class BeerDTOFactory {
    public static DTOBeer build(EBeer entityBeer) {
        DTOBeer result = new DTOBeer();
        result.setAbv(entityBeer.getAbv());
        result.setDescription(entityBeer.getDescription());
        result.setFg(entityBeer.getFg());
        result.setName(entityBeer.getName());
        result.setOg(entityBeer.getOg());
        result.setSrm(SRMUtil.toColor(entityBeer.getSrm()));
        return result;
    }
}

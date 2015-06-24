package com.bcoffield.taplist.server.dto.factory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.entity.EBeer;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class TapListDTOFactory {

    public DTOTapList build(List<EBeer> entityBeers) {
        DTOTapList result = new DTOTapList();
        List<DTOBeer> dtoBeers = entityBeers.stream().map(this::createDTOBeer).collect(Collectors.toList());
        result.setBeers(dtoBeers);
        return result;
    }

    private DTOBeer createDTOBeer(EBeer entityBeer) {
        DTOBeer result = new DTOBeer();
        result.setAbv(entityBeer.getAbv());
        result.setDescription(entityBeer.getDescription());
        result.setFg(entityBeer.getFg());
        result.setName(entityBeer.getName());
        result.setOg(entityBeer.getOg());
        result.setSrm(entityBeer.getSrm());
        return result;
    }
}

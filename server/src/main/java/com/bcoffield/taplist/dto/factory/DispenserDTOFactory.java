package com.bcoffield.taplist.dto.factory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.DTODispenser;
import com.bcoffield.taplist.entity.Dispenser;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DispenserDTOFactory implements IDispenserDTOFactory {
    @Inject
    private IBeerDTOFactory beerDTOFactory;

    @Override
    public List<DTODispenser> buildAll(List<Dispenser> dispensers) {
        List<DTODispenser> result = new ArrayList<>();
        for (Dispenser d : dispensers) {
            result.add(build(d));
        }
        return result;
    }

    @Override
    public DTODispenser build(Dispenser dispenser) {
        if (dispenser == null) {
            return null;
        }
        DTODispenser result = new DTODispenser();
        result.setId(dispenser.getId());
        result.setName(dispenser.getName());
        if (dispenser.getBeers() == null) {
            return result;
        }
        List<DTOBeer> dtoBeers = dispenser.getBeers().stream().map(beerDTOFactory::build).collect(Collectors.toList());
        result.setBeers(dtoBeers);
        return result;
    }
}

package com.bcoffield.taplist.dto.factory;

import com.bcoffield.taplist.dto.DTODispenser;
import com.bcoffield.taplist.entity.Dispenser;

import java.util.List;

public interface IDispenserDTOFactory {
    List<DTODispenser> buildAll(List<Dispenser> dispensers);
    DTODispenser build(Dispenser dispenser);
}

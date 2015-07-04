package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTODispenser;
import com.bcoffield.taplist.dto.factory.IDispenserDTOFactory;
import com.bcoffield.taplist.entity.Dispenser;
import com.bcoffield.taplist.service.IDispenserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("dispenser")
public class DispenserController {
    @Inject
    private IDispenserService dispenserService;
    @Inject
    private IDispenserDTOFactory dispenserDTOFactory;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<DTODispenser> getAll(@RequestParam(value = "count", defaultValue = "100") Integer count) {
        Page<Dispenser> dispensers = dispenserService.getAll(count);
        return dispenserDTOFactory.buildAll(dispensers.getContent());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public DTODispenser get(@PathVariable("id") Integer id) {
        Dispenser dispenser = dispenserService.findOne(id);
        return dispenserDTOFactory.build(dispenser);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public DTODispenser create(@RequestBody DTODispenser dtoDispenser) {
        Dispenser dispenser = dispenserService.create(dtoDispenser.getName());
        return dispenserDTOFactory.build(dispenser);
    }

}

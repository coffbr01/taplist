package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.dto.factory.TapListDTOFactory;
import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/ontap")
public class TapListController {
    @Inject
    private ITapListService tapListService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public DTOTapList get(@RequestParam(value = "count", defaultValue = "4") Integer count) {
        List<Beer> tapList = tapListService.getTapList(count);
        return TapListDTOFactory.build(tapList);
    }
}

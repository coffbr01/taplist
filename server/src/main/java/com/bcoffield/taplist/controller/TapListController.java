package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.dto.factory.TapListDTOFactory;
import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
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

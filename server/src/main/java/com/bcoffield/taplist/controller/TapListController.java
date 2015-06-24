package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.dto.factory.TapListDTOFactory;
import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TapListController {
    private static final String PATH = "/ontap";
    final private ITapListService tapListService;

    @Autowired
    public TapListController(ITapListService tapListService) {
        this.tapListService = tapListService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET)
    @ResponseBody
    public DTOTapList get(Integer count) {
        List<EBeer> tapList = tapListService.getTapList(count);
        return TapListDTOFactory.build(tapList);
    }
}

package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.dto.DTOTapList;
import com.bcoffield.taplist.dto.factory.TapListDTOFactory;
import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TapListController {
    private static final String PATH = "/ontap";
    @Inject
    private ITapListService tapListService;

    @RequestMapping(value = PATH, method = RequestMethod.GET)
    @ResponseBody
    public DTOTapList get(Integer count) {
        if (count == null) {
            count = 4;
        }
        List<Beer> tapList = tapListService.getTapList(count);
        return TapListDTOFactory.build(tapList);
    }
}

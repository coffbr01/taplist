package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.bean.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TapListController {
    final private IMessageService messageService;

    @Autowired
    public TapListController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return messageService.getMessage();
    }
}

package com.bcoffield.taplist.bean;

import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {
    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}

package com.userservice.sahand.Chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class ChatsController {
    @Autowired
    ChatsInterface chatsInterface;

    @GetMapping("/test")
    public boolean writeMsg(@RequestBody ChatsForm chatsForm) throws Exception {
        return chatsInterface.sendMsg(chatsForm);
    }
}

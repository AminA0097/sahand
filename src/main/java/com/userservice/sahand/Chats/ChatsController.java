package com.userservice.sahand.Chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class ChatsController {
    @Autowired
    ChatsInterface chatsInterface;
    @GetMapping("/test")
    public Map test() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("uuid",chatsInterface.addChat());
        return map;
    }
}

package com.userservice.sahand.Chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/msg")
public class ChatsController {
    @Autowired
    ChatsInterface chatsInterface;

    @GetMapping("/test")
    public boolean writeMsg(@RequestBody ChatsForm chatsForm) throws Exception {
        return chatsInterface.sendMsg(chatsForm);
    }

    @PostMapping("/test")
    public ResponseEntity<?> test() throws Exception {
        Map<String, Object> body = Map.of(
                "status", "status",
                "message", "List.of(messages)"
        );
        return ResponseEntity.status(200).body(body);
    }
}

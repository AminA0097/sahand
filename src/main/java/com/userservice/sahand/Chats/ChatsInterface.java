package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesInterface;
import com.userservice.sahand.Persons.PersonsEntity;
import org.springframework.http.ResponseEntity;

public interface ChatsInterface extends BasesInterface<ChatsEntity> {
    public String addChat()throws Exception;
}

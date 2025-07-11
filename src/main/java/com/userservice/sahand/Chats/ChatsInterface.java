package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesInterface;
import com.userservice.sahand.Persons.PersonsEntity;

public interface ChatsInterface extends BasesInterface<ChatsEntity> {
    public boolean addChat()throws Exception;
}

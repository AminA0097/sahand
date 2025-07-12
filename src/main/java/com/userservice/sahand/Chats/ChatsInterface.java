package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesInterface;

public interface ChatsInterface extends BasesInterface<ChatsEntity> {
    public boolean sendMsg(ChatsForm chatsForm)throws Exception;
}

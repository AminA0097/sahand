package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Users.UsersEntity;

import java.util.List;

public class ChatsForm extends BasesForm {
    private long chatId;
    private List<UsersEntity> recipients;

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public List<UsersEntity> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<UsersEntity> recipients) {
        this.recipients = recipients;
    }

    @Override
    public Long getId() {
        return this.chatId;
    }
}

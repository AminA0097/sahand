package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Utils.M2MFiled;
import com.userservice.sahand.Utils.RelatedFiled;

import java.util.List;
import java.util.Set;

public class ChatsForm extends BasesForm {
    private Long chatId;

    @M2MFiled(EntityName = UsersEntity.class)
    private Set<Long> receivers;

    @RelatedFiled(EntityName = UsersEntity.class, FieldName = "userId")
    private Long joinSender;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Set<Long> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Long> receivers) {
        this.receivers = receivers;
    }

    public Long getJoinSender() {
        return joinSender;
    }

    public void setJoinSender(Long joinSender) {
        this.joinSender = joinSender;
    }

    @Override
    public Long getId() {
        return this.chatId;
    }
}

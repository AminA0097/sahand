package com.userservice.sahand.ChatContainer;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ChatContainerEntity extends BasesEntity {
    @Column(name = "FLD_CHAT_CONTAINER_ID")
    private Long ChatContainerId;
    @Column(name = "FLD_CHAT_CONTAINER_NAME")
    private String ChatContainerName;
    @Column(name = "FLD_CHAT_CONTAINER_NAME_FA")
    private String ChatContainerNameFa;

    public Long getChatContainerId() {
        return ChatContainerId;
    }

    public void setChatContainerId(Long chatContainerId) {
        ChatContainerId = chatContainerId;
    }

    public String getChatContainerName() {
        return ChatContainerName;
    }

    public void setChatContainerName(String chatContainerName) {
        ChatContainerName = chatContainerName;
    }

    public String getChatContainerNameFa() {
        return ChatContainerNameFa;
    }

    public void setChatContainerNameFa(String chatContainerNameFa) {
        ChatContainerNameFa = chatContainerNameFa;
    }
}

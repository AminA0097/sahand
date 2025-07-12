package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Users.UsersEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CHATS_ENTITY")
@TableGenerator(
        name = "CORE_CHAT_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "ChatsEntitySeq",
        allocationSize = 1
)
public class ChatsEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_CHAT_ID")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "CORE_CHAT_SEQ")
    private Long chatId;

    @Column(name = "FLD_CHAT_TITLE")
    private String chatTitle;

    @Column(name = "FLD_CHAT_DESCRIPTION")
    private String chatDescription;

    @ManyToOne
    @JoinColumn(name = "FLD_JOIN_SENDER_ID")
    private UsersEntity joinSender;

    @ManyToMany
    @JoinTable(
            name = "M2M_FOR_CHATS",
            joinColumns = @JoinColumn(name = "FLD_CHAT_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLD_RECEIVER_ID"))
    private Set<UsersEntity> receivers;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public String getChatDescription() {
        return chatDescription;
    }

    public void setChatDescription(String chatDescription) {
        this.chatDescription = chatDescription;
    }

    public UsersEntity getJoinSender() {
        return joinSender;
    }

    public void setJoinSender(UsersEntity joinSender) {
        this.joinSender = joinSender;
    }

    public Set<UsersEntity> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<UsersEntity> receivers) {
        this.receivers = receivers;
    }

    @Override
    public Long getId() {
        return this.chatId;
    }
}

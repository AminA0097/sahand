package com.userservice.sahand.ChatChannel;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Users.UsersEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CORE_CHAT_CHANNEL")
@TableGenerator(
        name = "CORE_CHAT_CHANNEL_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "ChatChannelEntitySeq",
        allocationSize = 1
)
public class ChatChannelEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_CHAT_CHANNEL_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CORE_CHAT_CHANNEL_SEQ")
    private Long ChatChannelId;

    @Column(name = "FLD_CHAT_CHANNEL_TITLE")
    private String ChatChannelTitle;

    @Column(name = "FLD_CHAT_CHANNEL_DESCRIPTION")
    private String ChatChannelDescription;

    @ManyToMany
    @JoinTable(
            name = "M2M_FOR_CHAT_CHANNEL_ADMIN",
            joinColumns = @JoinColumn(name = "FLD_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLD_CHAT_GROUP_ID"))
    private Set<UsersEntity> ChatChannelAdmin;

    @ManyToOne
    @JoinColumn(name = "FLD_CHAT_CHANNEL_OWNER")
    private UsersEntity ChatChannelOwner;

    @ManyToMany
    @JoinTable(
            name = "M2M_FOR_CHAT_CHANNEL_MEMEBERS",
            joinColumns = @JoinColumn(name = "FLD_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLD_CHAT_GROUP_ID"))
    private Set<UsersEntity> ChatChannelMembers;


    @Override
    public Long getId() {
        return this.ChatChannelId;
    }

    public Long getChatChannelId() {
        return ChatChannelId;
    }

    public void setChatChannelId(Long chatChannelId) {
        ChatChannelId = chatChannelId;
    }

    public String getChatChannelTitle() {
        return ChatChannelTitle;
    }

    public void setChatChannelTitle(String chatChannelTitle) {
        ChatChannelTitle = chatChannelTitle;
    }

    public String getChatChannelDescription() {
        return ChatChannelDescription;
    }

    public void setChatChannelDescription(String chatChannelDescription) {
        ChatChannelDescription = chatChannelDescription;
    }

    public Set<UsersEntity> getChatChannelAdmin() {
        return ChatChannelAdmin;
    }

    public void setChatChannelAdmin(Set<UsersEntity> chatChannelAdmin) {
        ChatChannelAdmin = chatChannelAdmin;
    }

    public UsersEntity getChatChannelOwner() {
        return ChatChannelOwner;
    }

    public void setChatChannelOwner(UsersEntity chatChannelOwner) {
        ChatChannelOwner = chatChannelOwner;
    }


    public Set<UsersEntity> getChatChannelMembers() {
        return ChatChannelMembers;
    }

    public void setChatChannelMembers(Set<UsersEntity> chatChannelMembers) {
        ChatChannelMembers = chatChannelMembers;
    }
}

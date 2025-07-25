package com.userservice.sahand.ChatChannelMsg;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.ChatChannel.ChatChannelEntity;
import com.userservice.sahand.Documents.DocumentsEntity;
import com.userservice.sahand.Users.UsersEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_CHAT_CHANNEL")
@TableGenerator(
        name = "CORE_CHAT_CHANNEL_MSG_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "ChatChannelMsgEntitySeq",
        allocationSize = 1
)
public class ChatChannelMsgEntity extends BasesEntity {

    @Id
    @Column(name = "FLD_CHANNEL_MSG_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CORE_CHAT_CHANNEL_SEQ")
    private Long ChatChannelMsgId;

    @ManyToOne
    @JoinColumn(name = "FLD_CHANNEL_ID")
    private ChatChannelEntity ChatChannel;

    @ManyToOne
    @JoinColumn(name = "FLD_CHANNEL_MSG_SENDER_ID")
    private UsersEntity sender;

    @Column(name = "FLD_MSG_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "FLD_DOC_ID")
    private DocumentsEntity documentsEntity;

    @Override
    public Long getId() {
        return this.ChatChannelMsgId;
    }
}

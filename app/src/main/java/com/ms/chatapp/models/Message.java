package com.ms.chatapp.models;

public class Message {
    private String messageId;
    private String content;
    private String sendBy;
    private long sendDate;
    private long sendTime;

    public Message(String messageId, String content, String sendBy, long sendDate, long sendTime) {
        this.messageId = messageId;
        this.content = content;
        this.sendBy = sendBy;
        this.sendDate = sendDate;
        this.sendTime = sendTime;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public long getSendDate() {
        return sendDate;
    }

    public void setSendDate(long sendDate) {
        this.sendDate = sendDate;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }
}

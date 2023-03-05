package com.ms.chatapp.models;

import java.util.List;

public class Chat {
    private String chatID;
    private String chatName;
    private String description;
    private String lastMessageSent;
    private String createdBy;
    private long createdAt;
    private List<String> members;

    public Chat(String chatID, String chatName, String description, String lastMessageSent, String createdBy, long createdAt, List<String> members) {
        this.chatID = chatID;
        this.chatName = chatName;
        this.description = description;
        this.lastMessageSent = lastMessageSent;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.members = members;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastMessageSent() {
        return lastMessageSent;
    }

    public void setLastMessageSent(String lastMessageSent) {
        this.lastMessageSent = lastMessageSent;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}

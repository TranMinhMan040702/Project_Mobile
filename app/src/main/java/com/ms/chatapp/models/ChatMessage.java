package com.ms.chatapp.models;

public class ChatMessage {
    private String chatID;
    private String messageID;

    public ChatMessage(String chatID, String messageID) {
        this.chatID = chatID;
        this.messageID = messageID;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
}

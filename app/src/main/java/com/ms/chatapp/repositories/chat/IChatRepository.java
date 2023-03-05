package com.ms.chatapp.repositories.chat;

import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.models.Chat;
import com.ms.chatapp.models.ChatMessage;
import com.ms.chatapp.services.firebase.IFirebaseService;


public interface IChatRepository extends IFirebaseService<Chat> {

    int readChatMessages(String chatID, ValueEventListener e);
    int createChatMessage(ChatMessage chatMessage);
}

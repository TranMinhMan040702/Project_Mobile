package com.ms.chatapp.repositories.chat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.models.Chat;
import com.ms.chatapp.models.ChatMessage;
import com.ms.chatapp.repositories.user.UserRepository;


public class ChatRepository implements IChatRepository {
    private static UserRepository instance = null;
    private static final String CHATS = "chats";
    private static final String CHAT_MESSAGES = "chatMessages";
    private static final String URL = "https://chatapp-b4e39-default-rtdb.asia-southeast1.firebasedatabase.app/";

    public static UserRepository getInstance(){
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }
    @Override
    public int readChatMessages(String chatID, ValueEventListener e) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(CHAT_MESSAGES);
            databaseReference.child(chatID).addValueEventListener(e);
            return 1;
        }catch(Exception err){
            return -1;
        }
    }

    @Override
    public int createChatMessage(ChatMessage chatMessage) {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(CHAT_MESSAGES);
            databaseReference.child(chatMessage.getChatID()).setValue(chatMessage.getMessageID());
            return 1;
        }
        catch(Exception err){
            return -1;
        }
    }

    @Override
    public int create(Chat e) {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(CHATS);
            databaseReference.child(e.getChatID()).setValue(e);
            return 1;
        }
        catch(Exception err){
            return -1;
        }
    }

    @Override
    public int update(Chat e) {
        return 0;
    }

    @Override
    public int read(String id, ValueEventListener e) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(CHATS);
            databaseReference.child(id).addValueEventListener(e);
            return 1;
        }catch(Exception err){
            return -1;
        }
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}

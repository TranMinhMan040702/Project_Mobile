package com.ms.chatapp.repositories.message;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.models.Message;

public class MessageRepository implements IMessageRepository{
    private static MessageRepository instance = null;
    private static final String MESSAGES = "messages";
    private static final String URL = "https://chatapp-b4e39-default-rtdb.asia-southeast1.firebasedatabase.app/";

    public static MessageRepository getInstance(){
        if (instance == null)
            instance = new MessageRepository();
        return instance;
    }
    @Override
    public int create(Message e) {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(MESSAGES);
            databaseReference.child(e.getMessageId()).setValue(e);
            return 1;
        }
        catch(Exception err){
            return -1;
        }
    }

    @Override
    public int update(Message e) {
        return 0;
    }

    @Override
    public int read(String id, ValueEventListener e) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(MESSAGES);
            databaseReference.child(id).addValueEventListener(e);
            return 1;
        }catch(Exception err){
            return -1;
        }
    }

    @Override
    public int delete(String id) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(MESSAGES);
            databaseReference.child(id).removeValue();
            return 1;
        }catch(Exception err){
            return -1;
        }
    }
}

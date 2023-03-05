package com.ms.chatapp.repositories.user;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.models.User;
import com.ms.chatapp.models.UserChat;

public class UserRepository implements IUserRepository{
    private static UserRepository instance = null;
    private static final String USERS = "users";
    private static final String USER_CHATS = "userChats";
    private static final String URL = "https://chatapp-b4e39-default-rtdb.asia-southeast1.firebasedatabase.app/";

    public static UserRepository getInstance(){
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }
    @Override
    public int readUserChats(String userID, ValueEventListener e) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(USER_CHATS);
            databaseReference.child(userID).addValueEventListener(e);
            return 1;
        }catch(Exception err){
            return -1;
        }
    }

    @Override
    public int createUserChats(UserChat userChat) {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(USER_CHATS);

            databaseReference.child(userChat.getUserId()).setValue(userChat.getChatId(), (error, ref) -> {
                if(error != null )
                    throw error.toException();
            });
            return 1;
        }
        catch(Exception err){
            return -1;
        }
    }

    @Override
    public int create(User e) {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(USERS);
            databaseReference.child(e.getUserID()).setValue(e, (error, ref) -> {
                if(error != null )
                    throw error.toException();
            });
            return 1;
        }
        catch(Exception err){
            return -1;
        }
    }

    @Override
    public int update(User e) {
        return 0;
    }

    @Override
    public int read(String id, ValueEventListener e) {
        try{

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(USERS);
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
            DatabaseReference databaseReference = firebaseDatabase.getReference(USERS);
//            databaseReference.child(id).removeValue();
            return 1;
        }catch(Exception err){
            return -1;
        }
    }
}

package com.ms.chatapp.repositories.auth;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.dtos.auth.LoginRequest;
import com.ms.chatapp.models.User;
import com.ms.chatapp.repositories.user.UserRepository;

import java.util.Map;

public class AuthRepository implements IAuthRepository{
    private static AuthRepository instance = null;
    private static final String USERS = "users";
    private static final String URL = "https://chatapp-b4e39-default-rtdb.asia-southeast1.firebasedatabase.app/";

    public static AuthRepository getInstance(){
        if (instance == null)
            instance = new AuthRepository();
        return instance;
    }
    @Override
    public void Login(ValueEventListener e) {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(URL);
            DatabaseReference databaseReference = firebaseDatabase.getReference(USERS);
            databaseReference.addValueEventListener(e);
        }catch(Exception err){
            return;
        }
    }
}

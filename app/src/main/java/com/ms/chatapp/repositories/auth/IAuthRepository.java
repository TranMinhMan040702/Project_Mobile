package com.ms.chatapp.repositories.auth;

import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.dtos.auth.LoginRequest;

public interface IAuthRepository {
    void Login(ValueEventListener e);
}

package com.ms.chatapp.repositories.user;

import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.models.User;
import com.ms.chatapp.models.UserChat;
import com.ms.chatapp.services.firebase.IFirebaseService;

public interface IUserRepository extends IFirebaseService<User> {
    int readUserChats(String userID, ValueEventListener e);
    int createUserChats(UserChat userChat);
}

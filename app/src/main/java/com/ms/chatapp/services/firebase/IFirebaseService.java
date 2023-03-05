package com.ms.chatapp.services.firebase;

import com.google.firebase.database.ValueEventListener;

public interface IFirebaseService<EntityType> {
    int create(EntityType e);
    int update(EntityType e);
    int read(String id, ValueEventListener e);
    int delete(String id);
}

package com.ms.chatapp.repositories.message;

import com.ms.chatapp.models.Message;
import com.ms.chatapp.services.firebase.IFirebaseService;

public interface IMessageRepository extends IFirebaseService<Message> {

}

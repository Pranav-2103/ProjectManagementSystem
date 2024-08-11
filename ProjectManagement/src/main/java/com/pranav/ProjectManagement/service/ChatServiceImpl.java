package com.pranav.ProjectManagement.service;

import com.pranav.ProjectManagement.Model.Chat;
import com.pranav.ProjectManagement.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }
}

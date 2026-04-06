package com.yojnasetu.gateway.repository;

import com.yojnasetu.gateway.model.ChatMessage;
import com.yojnasetu.gateway.model.ChatSession;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findBySessionOrderByTimestampAsc(ChatSession session);

    void deleteBySession(ChatSession session);
}

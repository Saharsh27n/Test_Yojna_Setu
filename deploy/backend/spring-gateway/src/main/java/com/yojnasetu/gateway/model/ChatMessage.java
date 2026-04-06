package com.yojnasetu.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/** A single message within a chat session. */
@Document(collection = "chat_messages")
@Data
@NoArgsConstructor
public class ChatMessage {

    @Id
    private String id;

    @DBRef
    private ChatSession session;

    /**
     * Message role: USER or ASSISTANT
     */
    private String role;

    private String content;

    /**
     * JSON array of scheme keys mentioned, e.g. ["pmkisan","nrega"]
     * Stored as text for portability.
     */
    private String schemesmentioned;

    @CreatedDate
    private LocalDateTime timestamp;
}
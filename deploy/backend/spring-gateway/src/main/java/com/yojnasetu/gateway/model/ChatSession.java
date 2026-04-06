package com.yojnasetu.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/** A single conversation session between a user (or guest) and the AI. */
@Document(collection = "chat_sessions")
@Data
@NoArgsConstructor
public class ChatSession {

    @Id
    private String id;

    /** The UUID session identifier passed by the client */
    @Indexed(unique = true)
    private String sessionId;

    /** Null for unauthenticated / guest users */
    @DBRef
    private User user;

    /** Language used in this session, e.g. "hi-IN" */
    private String language;

    /** Indian state context, e.g. "Bihar" */
    private String state;

    /** Type of session: CHAT, AGENT, VOICE */
    private String sessionType;

    @CreatedDate
    private LocalDateTime startedAt;

    @LastModifiedDate
    private LocalDateTime lastActivityAt;
}
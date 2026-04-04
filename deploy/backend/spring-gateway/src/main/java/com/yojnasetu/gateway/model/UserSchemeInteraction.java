package com.yojnasetu.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Tracks every interaction a user has with a scheme:
 * viewing it, bookmarking it, or submitting an application.
 */
@Document(collection = "user_scheme_interactions")
@Data
@NoArgsConstructor
public class UserSchemeInteraction {

    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Scheme scheme;

    /**
     * Type of interaction:
     * VIEWED — user read about this scheme in chat
     * BOOKMARKED — user explicitly saved it
     * APPLIED — user started the application wizard
     */
    @Indexed
    private String interactionType;

    /** Application reference ID, if the user has applied */
    private String applicationId;

    /** Current application status, if known */
    private String applicationStatus;

    @CreatedDate
    private LocalDateTime timestamp;
}
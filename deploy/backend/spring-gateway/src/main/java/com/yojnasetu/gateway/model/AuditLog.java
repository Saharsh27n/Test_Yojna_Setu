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
 * Immutable audit trail — every important user action is recorded here.
 * Never update or delete rows in this table.
 */
@Document(collection = "audit_log")
@Data
@NoArgsConstructor
public class AuditLog {

    @Id
    private String id;

    /** User who performed the action (null for anonymous) */
    @DBRef
    private User user;

    /**
     * Action performed, e.g.:
     * USER_REGISTERED, USER_LOGIN, USER_LOGIN_FAILED,
     * PROFILE_UPDATED, SCHEME_VIEWED, SCHEME_BOOKMARKED,
     * STATUS_CHECKED, CHAT_STARTED, VOICE_SESSION_STARTED
     */
    @Indexed
    private String action;

    /** Type of resource involved: USER, SCHEME, CHAT_SESSION, STATUS_CHECK */
    private String resourceType;

    /** ID of the resource (e.g. scheme key, session ID) */
    private String resourceId;

    /** Client IP address (anonymized last octet: "192.168.1.xxx") */
    private String ipAddress;

    /** Additional context in JSON format */
    private String details;

    @CreatedDate
    private LocalDateTime timestamp;
}
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
 * Logs every call to the status-checker endpoint.
 * The identifier is always stored MASKED (e.g. XXXX-XXXX-1234) — never raw.
 */
@Document(collection = "status_check_logs")
@Data
@NoArgsConstructor
public class StatusCheckLog {

    @Id
    private String id;

    /** Can be null for guest users */
    @DBRef
    private User user;

    /** e.g. "pmkisan", "nrega" */
    @Indexed
    private String schemeKey;

    /** PII-masked identifier, e.g. "XXXXXXXX-1234" */
    private String maskedIdentifier;

    /** The stage returned by the status check */
    private String resultStage;

    /** How long the government portal took to reply (ms) */
    private Long responseTimeMs;

    /** Whether the result was served from cache */
    private Boolean cached = false;

    /** Optional state code for stateful schemes (NREGA) */
    private String stateCode;

    @CreatedDate
    private LocalDateTime checkedAt;
}
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

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String email;

    private String passwordHash;

    /** Indian state name, e.g. "Rajasthan", "Bihar" */
    private String state;

    /** BCP-47 language code, e.g. "hi-IN", "ta-IN" */
    private String language;

    /** Optional phone number (used for OTP in future) */
    private String phoneNumber;

    /** Age of the user (helps in scheme eligibility) */
    private Integer age;

    /** Social category: GENERAL, OBC, SC, ST, EWS */
    private String category;

    /** Whether the account is active */
    private boolean isActive = true;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime lastLoginAt;

    /** One-to-one relationship with UserProfile */
    @DBRef
    private UserProfile profile;

    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}
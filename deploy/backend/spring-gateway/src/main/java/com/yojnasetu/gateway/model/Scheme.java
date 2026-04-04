package com.yojnasetu.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Government scheme entity — replaces the flat schemes_lite.json file.
 */
@Document(collection = "schemes")
@Data
@NoArgsConstructor
public class Scheme {

    @Id
    private String id;

    /** Short unique identifier, e.g. "pmkisan", "nrega" */
    @Indexed(unique = true)
    private String schemeKey;

    private String name;

    /** Sector: AGRICULTURE, HOUSING, EDUCATION, HEALTH, WOMEN, EMPLOYMENT, etc. */
    private String sector;

    private String description;

    private String eligibility;

    private String benefit;

    private String applyUrl;

    private String helpline;

    /** Minimum age to be eligible (null = no restriction) */
    private Integer minAge;
    private Integer maxAge;

    /** Target gender: ALL, FEMALE, MALE */
    private String targetGender;

    /** Target social category: ALL, SC, ST, OBC, GENERAL, EWS */
    private String targetCategory;

    /** Maximum annual household income in INR to be eligible */
    private Long maxAnnualIncomeInr;

    /** Whether this scheme is currently active/available */
    private boolean isActive = true;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
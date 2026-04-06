package com.yojnasetu.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Extended profile for a registered user.
 * These socioeconomic fields determine scheme eligibility
 * and are used by the /api/profile/matching-schemes endpoint.
 */
@Document(collection = "user_profiles")
@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    private String id;

    @DBRef
    @Indexed(unique = true)
    private User user;

    /** District within the state */
    private String district;

    /** Annual family income in INR */
    private Long annualIncomeInr;

    /**
     * Occupation type: FARMER, DAILY_WAGE, SELF_EMPLOYED, GOVT_EMPLOYEE,
     * UNEMPLOYED, OTHER
     */
    private String occupation;

    /** Number of people in the family */
    private Integer familySize;

    /** Does the user have a BPL (Below Poverty Line) ration card? */
    private Boolean hasBplCard;

    /** Does the user have a regular ration card? */
    private Boolean hasRationCard;

    /** Aadhaar enrollment confirmed (we never store the number itself here) */
    private Boolean hasAadhaar;

    /** Has a bank account linked to Aadhaar */
    private Boolean hasBankAccount;

    /** Does the user have any disability? */
    private Boolean hasDisability;

    /** Disability percentage (if applicable, 0-100) */
    private Integer disabilityPercentage;

    /** Is the user a farmer? */
    private Boolean isFarmer;

    /** Land owned in acres (for farmer-specific schemes) */
    private Double landOwnedAcres;

    /** Gender: MALE, FEMALE, OTHER */
    private String gender;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
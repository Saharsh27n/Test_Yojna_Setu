package com.yojnasetu.gateway.repository;

import com.yojnasetu.gateway.model.UserProfile;
import com.yojnasetu.gateway.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    Optional<UserProfile> findByUser(User user);
}

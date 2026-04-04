package com.yojnasetu.gateway.repository;

import com.yojnasetu.gateway.model.UserSchemeInteraction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSchemeInteractionRepository extends MongoRepository<UserSchemeInteraction, String> {
}

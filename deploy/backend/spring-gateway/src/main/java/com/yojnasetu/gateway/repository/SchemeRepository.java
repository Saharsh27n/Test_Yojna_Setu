package com.yojnasetu.gateway.repository;

import com.yojnasetu.gateway.model.Scheme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface SchemeRepository extends MongoRepository<Scheme, String> {
    Optional<Scheme> findBySchemeKey(String schemeKey);
    List<Scheme> findByIsActiveTrue();
}

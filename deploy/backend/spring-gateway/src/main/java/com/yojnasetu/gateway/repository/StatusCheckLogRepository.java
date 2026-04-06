package com.yojnasetu.gateway.repository;

import com.yojnasetu.gateway.model.StatusCheckLog;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatusCheckLogRepository extends MongoRepository<StatusCheckLog, String> {

    /**
     * Cache lookup: find the most recent successful log for a scheme+identifier
     * within a given time window, excluding error results.
     */
    @Query("{ 'schemeKey': ?0, 'maskedIdentifier': ?1, 'checkedAt': { $gte: ?2 }, " +
            "'resultStage': { $not: { $regex: 'Check portal directly|Unable to fetch' } } }")
    List<StatusCheckLog> findRecentSuccessfulLogs(
            @Param("schemeKey") String schemeKey,
            @Param("maskedId") String maskedIdentifier,
            @Param("since") LocalDateTime since);

    @Aggregation(pipeline = {
            "{ $group: { _id: '$schemeKey', cnt: { $sum: 1 } } }",
            "{ $sort: { cnt: -1 } }",
            "{ $limit: ?0 }"
    })
    List<Object[]> findPopularSchemes(@Param("limit") int limit);
}

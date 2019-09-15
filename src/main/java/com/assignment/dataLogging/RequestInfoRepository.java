package com.assignment.dataLogging;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shan
 * <p>
 * RequestInfo repository
 */
@Repository
public interface RequestInfoRepository extends MongoRepository<RequestInfo, Integer> {

}

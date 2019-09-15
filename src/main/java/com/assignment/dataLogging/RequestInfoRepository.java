package com.assignment.dataLogging;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInfoRepository extends MongoRepository<RequestInfo, Integer> {

}

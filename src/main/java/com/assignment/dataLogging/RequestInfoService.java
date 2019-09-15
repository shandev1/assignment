package com.assignment.dataLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shan
 * <p>
 * Request and response logging service
 */
@Service
public class RequestInfoService {

    private static final Logger logger = LoggerFactory.getLogger(RequestInfoService.class);

    @Autowired
    private RequestInfoRepository requestInfoRepository;

    public void insertRequest(RequestInfo requestInfo) {
        logger.info("New request info saved");

        requestInfoRepository.save(requestInfo);
    }

    public List<RequestInfo> getAllRequests() {
        logger.info("Retrieving all request info");

        return requestInfoRepository.findAll();
    }

}

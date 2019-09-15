package com.assignment.dataLogging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestInfoService {

    @Autowired
    private RequestInfoRepository requestInfoRepository;

    public void insertRequest(RequestInfo requestInfo) {
        requestInfoRepository.save(requestInfo);
    }

    public List<RequestInfo> getAllRequests() {
        return requestInfoRepository.findAll();
    }

}

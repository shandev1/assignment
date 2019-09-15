package com.assignment.dataLogging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shan
 * <p>
 * Sample implementation of request and response logger
 * Intercepts requests and responses and save to the database
 */
@Component
public class RequestLoggingInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Autowired
    private RequestInfoService requestInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

        RequestLog requestLog = new RequestLog();
        requestLog.setMethod(request.getMethod());
        requestLog.setRequestUrl(request.getRequestURI());

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestJson = mapper.writeValueAsString(requestLog);

            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setRequest(requestJson);

            requestInfoService.insertRequest(requestInfo);
            logger.info("Request logged");
        } catch (Exception ex) {
            logger.warn("Request logging failed : []", ex.getMessage());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) {

        ResponseLog responseLog = new ResponseLog();
        responseLog.setStatus(response.getStatus());
        responseLog.setContentType(response.getContentType());

        try {
            ObjectMapper mapper = new ObjectMapper();
            String responseJson = mapper.writeValueAsString(responseLog);

            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setResponse(responseJson);

            requestInfoService.insertRequest(requestInfo);
            logger.info("Response logged");
        } catch (Exception ex) {
            logger.warn("Response logging failed : []", ex.getMessage());
        }

    }

    @Getter
    @Setter
    public static class RequestLog {
        private String requestUrl;
        private String method;
    }

    @Getter
    @Setter
    public static class ResponseLog {
        private int status;
        private String contentType;
    }

}

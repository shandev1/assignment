package com.assignment.dataLogging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Document(collection= "RequestInfo")
public class RequestInfo {

    @Id
    private String id;

    private String request;
    private String response;

}

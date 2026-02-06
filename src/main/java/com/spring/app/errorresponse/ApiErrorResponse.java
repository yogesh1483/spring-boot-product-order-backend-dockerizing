package com.spring.app.errorresponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse{
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String errorCode;
    private String path;

}



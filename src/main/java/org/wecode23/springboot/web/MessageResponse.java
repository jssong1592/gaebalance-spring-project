package org.wecode23.springboot.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat()
public enum MessageResponse {
    OK("OK"),
    CREATED("CREATED");

    private String Code;

    MessageResponse(String Code) {
        this.Code = Code;
    }

    @JsonValue
    public String getCode() {
        return this.Code;
    }
}

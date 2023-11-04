package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class SmsDto {
    private String to;
    private String message;

    public SmsDto(String phoneNumber, String message) {
        this.to = phoneNumber;
        this.message = message;
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


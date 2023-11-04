package com.example.demo.controller;

import com.example.demo.event.SmsEvent;
import com.example.demo.model.SmsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class SmsRestController{

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    Logger logger = LoggerFactory.getLogger(SmsRestController.class);

    @PostMapping({"/sms/send"})
    public ResponseEntity<?> sendSms(@RequestBody SmsDto smsDto) {
        this.applicationEventPublisher.publishEvent(new SmsEvent(smsDto));
        Map response = new HashMap();
        response.put("message", "Successful");
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }

}
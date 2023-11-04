package com.example.demo.controller;

import com.example.demo.event.SmsEvent;
import com.example.demo.model.SmsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SmsControllerImpl implements SmsController {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    Logger logger = LoggerFactory.getLogger(SmsControllerImpl.class);

    @GetMapping
    public String index(SmsDto smsDto, Model model) {
        return "sms/sms";
    }

    @PostMapping({"/sms/send"})
    public String sendSms( SmsDto smsDto, Model model) {
        this.applicationEventPublisher.publishEvent(new SmsEvent(smsDto));
        model.addAttribute("message", "Message sent successfully.");
        return "sms/sms";
    }

}
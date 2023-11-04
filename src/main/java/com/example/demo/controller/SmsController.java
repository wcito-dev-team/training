package com.example.demo.controller;

import com.example.demo.model.SmsDto;
import org.springframework.ui.Model;

public interface SmsController {
    String sendSms(SmsDto smsDto, Model model);
}

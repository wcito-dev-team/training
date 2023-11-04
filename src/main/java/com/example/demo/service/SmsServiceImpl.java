package com.example.demo.service;

import com.example.demo.model.SmsDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Value("${twilio_account_sid}")
    private String accountSid;

    @Value("${twilio_auth_token}")
    private String authToken;

    @Value("${twilio_sms_sender}")
    private String smsSender;

    @Override
    public void sendSms(SmsDto smsDTO) {
        Twilio.init(accountSid, authToken);
        Message.creator(new PhoneNumber(smsDTO.getPhoneNumber()),
                new PhoneNumber(smsSender), smsDTO.getMessage()
        ).create();
    }
}

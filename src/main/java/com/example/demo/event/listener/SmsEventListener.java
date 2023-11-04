package com.example.demo.event.listener;

import com.example.demo.event.SmsEvent;
import com.example.demo.model.SmsDto;
import com.example.demo.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SmsEventListener implements ApplicationListener<SmsEvent> {
    private Logger logger = LoggerFactory.getLogger(SmsEventListener.class);
    @Autowired
    SmsService smsService;
    public SmsEventListener() {
    }

    public void onApplicationEvent(SmsEvent smsEvent) {
        List<SmsDto> smsDtoList = Arrays.stream(
                smsEvent.getEventData().getTo().split(",")
        ).map(phoneNumber -> new SmsDto(
                phoneNumber,
                smsEvent.getEventData().getMessage()
        )).collect(Collectors.toList());

        smsDtoList.forEach(sms -> {
            this.smsService.sendSms(sms);
        });
    }
}

package com.example.demo.event;

import com.example.demo.model.SmsDto;
import org.springframework.context.ApplicationEvent;

public class SmsEvent extends ApplicationEvent {
    private SmsDto eventData;

    public SmsDto getEventData() {
        return this.eventData;
    }

    public SmsEvent(SmsDto eventData) {
        super(eventData);
        this.eventData = eventData;
    }
}

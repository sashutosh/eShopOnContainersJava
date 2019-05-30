package com.sashutosh.microservice.eventbus;

import java.util.Date;
import java.util.UUID;

public class IntegrationEvent {

    UUID eventId;
    Date creationTime;

    public IntegrationEvent()
    {
        eventId = UUID.randomUUID();
        creationTime=new Date();
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

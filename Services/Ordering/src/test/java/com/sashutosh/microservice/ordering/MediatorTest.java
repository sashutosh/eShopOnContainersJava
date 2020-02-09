package com.sashutosh.microservice.ordering;

import org.junit.Assert;
import org.junit.Test;

public class MediatorTest {

    @Test
    public void testClassLoading()
    {
        IMediator mediator= new IMediator();
        mediator.build();
        Assert.assertNotEquals(mediator.getCommandHandlermap().size(),0);
        Assert.assertNotNull(mediator.getCommandHandlermap().get("com.sashutosh.microservice.ordering.domain.OrderCancelledDomainEvent"));

    }
}

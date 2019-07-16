package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.integration.model.BasketItem;
import com.sashutosh.microservice.ordering.model.Order;

public class CreateOrderDraftCommandHandler implements IRequestHandler<CreateOrderDraftCommand, OrderDraft>{

    @Override
    public OrderDraft handle(CreateOrderDraftCommand cmd) {
        Order order  = Order.newDraftOrder();
        for (BasketItem item : cmd.getItems())
        {
            OrderItemDTO orderItemDTO= BasketItem.toOrderItemDTO(item);
            order.addOrderItem(orderItemDTO.getProductId(),orderItemDTO.getProductName(),orderItemDTO.getUnitPrice(),orderItemDTO.getDiscount(),orderItemDTO.getUnits(), orderItemDTO.getPictureUrl());

        }
        return OrderDraft.fromOrder(order);
    }
}

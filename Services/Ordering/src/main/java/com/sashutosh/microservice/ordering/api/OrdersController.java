package com.sashutosh.microservice.ordering.api;

import com.sashutosh.microservice.ordering.IMediator;
import com.sashutosh.microservice.ordering.commands.CancelOrderCommand;
import com.sashutosh.microservice.ordering.commands.CreateOrderDraftCommand;
import com.sashutosh.microservice.ordering.commands.IdentifiedCommand;
import com.sashutosh.microservice.ordering.commands.ShipOrderCommand;
import com.sashutosh.microservice.ordering.model.CardType;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrdersController {

    @Autowired
    IMediator mediator;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelOrder(@RequestBody CancelOrderCommand cancelOrder, @RequestHeader(value="x-requestid")String requestId)
    {
        boolean cmdResult=false;
        if(requestId!=null&& requestId.length() >0) {

            try {
                UUID cmdRequestID = UUID.fromString(requestId);
                IdentifiedCommand<CancelOrderCommand, Boolean> cmd = new IdentifiedCommand<>(cancelOrder,cmdRequestID);
                cmdResult= mediator.send(cmd);
            }
            catch (IllegalArgumentException ex){
                cmdResult=false;
            }

        }
        return cmdResult ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/ship")
    public ResponseEntity<?> shipOrder(@RequestBody ShipOrderCommand shipOrderCommand, @RequestHeader(value="x-requestid")String requestId)
    {
        boolean cmdResult=false;
        if(requestId!=null&& requestId.length() >0) {

            try {
                UUID cmdRequestID = UUID.fromString(requestId);
                IdentifiedCommand<ShipOrderCommand, Boolean> cmd = new IdentifiedCommand<>(shipOrderCommand,cmdRequestID);
                cmdResult= mediator.send(cmd);
            }
            catch (IllegalArgumentException ex){
                cmdResult=false;
            }

        }
        return cmdResult ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable(value="orderId")int orderId)
    {
        Optional<Order> order= orderRepository.findById(orderId);
        return order.orElse(null);
    }

    @GetMapping("/")
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }

    @GetMapping("/cardtypes")
    public List<CardType> getCardTypes(@PathVariable(value="orderId")int orderId)
    {
        return orderRepository.getCardTypes();
    }

    @PostMapping("/draft")
    public ResponseEntity<?> getOrderDraftFromBasketData(@RequestBody CreateOrderDraftCommand createOrderDraftCommand)
    {
        boolean cmdResult= mediator.send(createOrderDraftCommand);
        return cmdResult ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }




}

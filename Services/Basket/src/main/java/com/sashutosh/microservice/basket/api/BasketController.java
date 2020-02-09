package com.sashutosh.microservice.basket.api;

import com.sashutosh.microservice.basket.events.UserCheckoutAcceptedIntegrationEvent;
import com.sashutosh.microservice.basket.model.BasketCheckout;
import com.sashutosh.microservice.basket.model.CustomerBasket;
import com.sashutosh.microservice.basket.model.IBasketRepository;
import com.sashutosh.microservice.eventbus.IEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketController {


    @Autowired
    private IBasketRepository basketRepository;
    /*//@Autowired
    private IIdentityService _identitySvc;


    private IEventBus _eventBus;*/

    @Autowired
    IEventBus eventBus;



    /*public BasketController(IBasketRepository basketRepository, IIdentityService _identitySvc, IEventBus _eventBus) {
        this.basketRepository = basketRepository;
        this._identitySvc = _identitySvc;
        this._eventBus = _eventBus;
    }*/

    @GetMapping("/{id}")
    public CustomerBasket getBasket(@PathVariable(value="id")String customerId){

        CustomerBasket basket = basketRepository.getBasket(customerId);
        if(basket==null){
            return new CustomerBasket(customerId);
        }
        return basket;
    }


    @PostMapping("/")
    public CustomerBasket updateBasket(@RequestBody  CustomerBasket basket){
        return basketRepository.update(basket);
    }

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable(value="id")String customerId){
        basketRepository.delete(customerId);

    }

    //TO-DO - Change the path back without id
    @PostMapping("/checkout/{id}")
    public void checkout(@PathVariable(value="id")String customerId,@RequestBody BasketCheckout basketCheckout, @RequestHeader(value="x-requestid")String requestId){

       //1. Get the basket for the customerId
        CustomerBasket basket = basketRepository.getBasket(customerId);

        //TO-DO figure out how to get user name
        String userName="";
       //2. Create an event message containing the basket and checkout info.
        UserCheckoutAcceptedIntegrationEvent userCheckoutAcceptedIntegrationEvent = new UserCheckoutAcceptedIntegrationEvent(customerId,
                userName,basketCheckout.city,basketCheckout.street,basketCheckout.state,basketCheckout.country,basketCheckout.zipCode,basketCheckout.cardNumber,
                basketCheckout.cardHolderName,basketCheckout.cardExpiration,basketCheckout.cardSecurityNumber,basketCheckout.cardTypeId,basketCheckout.buyer,
                basketCheckout.requestId,basket);


        //3. Publish the event to message bus
        eventBus.publish(userCheckoutAcceptedIntegrationEvent);

    }




}

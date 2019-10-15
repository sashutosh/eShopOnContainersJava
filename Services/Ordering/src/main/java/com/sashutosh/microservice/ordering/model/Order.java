package com.sashutosh.microservice.ordering.model;



import com.sashutosh.microservice.ordering.domain.OrderShippedDomainEvent;
import com.sashutosh.microservice.ordering.domain.INotification;
import com.sashutosh.microservice.ordering.domain.OrderCancelledDomainEvent;
import com.sashutosh.microservice.ordering.domain.OrderStartedDomainEvent;
import com.sashutosh.microservice.ordering.exception.StatusChangeException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int orderNumber;
    Date orderDate;
    String status;

    String description;

    int buyerId;

    String street;
    String city;
    String zipCode;
    String country;

    boolean isDraft;

    int paymentMethodId;

    OrderStatus orderStatusId;

    Address address;

    @Transient
    List<INotification> events= new ArrayList<>();

    public Order(String userId, String userName, Address address, int cardTypeId, String cardNumber, String cardSecurityNumber, String cardHolderName, Date cardExpiration,
                 Integer buyerId ,Integer paymentMethodId)
    {
        this.buyerId=buyerId;
        this.paymentMethodId=paymentMethodId;
        this.orderStatusId= OrderStatus.Submitted;
        this.orderDate= new Date();
        this.address=address;
        addOrderStartedDomainEvent(userId,userName,cardTypeId,cardNumber,cardSecurityNumber,cardHolderName,cardExpiration);

    }

    private void addOrderStartedDomainEvent(String userId, String userName, int cardTypeId, String cardNumber, String cardSecurityNumber, String cardHolderName, Date cardExpiration) {

        OrderStartedDomainEvent orderStartedDomainEvent = new OrderStartedDomainEvent(this,userId,userName,cardTypeId,cardNumber,
                                                    cardSecurityNumber,cardHolderName,cardExpiration);
        this.addNewDomainEvent(orderStartedDomainEvent);
    }

    public Order() {
        orderItems= new ArrayList();
        isDraft=false;
    }


    public static Order newDraftOrder() {
        Order order = new Order();
        order.isDraft=true;
        return order;
    }

    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderItem> orderItems= new ArrayList<>();

    float total;

    public int getId() {
        return id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void addOrderItem(OrderItem orderItem)
    {
        orderItems.add(orderItem);
    }

    public void setCancelledStatus() throws StatusChangeException {
        if(orderStatusId == OrderStatus.Paid || (orderStatusId == OrderStatus.Shipped)){

            throw new StatusChangeException(this);
        }
        this.orderStatusId=OrderStatus.Cancelled;
        addNewDomainEvent(new OrderCancelledDomainEvent(this));
    }

    public void setShippedStatus() throws StatusChangeException
    {
        if(orderStatusId != OrderStatus.Paid){

            throw new StatusChangeException(this);
        }
        this.orderStatusId=OrderStatus.Shipped;
        addNewDomainEvent(new OrderShippedDomainEvent(this));

    }

    private void addNewDomainEvent(INotification domainEvent)
    {
        events.add(domainEvent);
    }

    public void addOrderItem(int productId, String productName, float unitPrice, float discount, int quantity, String pictureUrl) {

        OrderItem existingProduct= (OrderItem) orderItems.stream().filter(orderItem -> orderItem.getItemId()== productId).collect(Collectors.toList());
        if(discount > existingProduct.getDiscount()){
            existingProduct.setDiscount(discount);
        }
    }


}

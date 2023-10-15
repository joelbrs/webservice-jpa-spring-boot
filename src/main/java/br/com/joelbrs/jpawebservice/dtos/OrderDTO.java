package br.com.joelbrs.jpawebservice.dtos;

import br.com.joelbrs.jpawebservice.entities.Order;
import br.com.joelbrs.jpawebservice.entities.OrderItem;
import br.com.joelbrs.jpawebservice.entities.Payment;
import br.com.joelbrs.jpawebservice.entities.User;
import br.com.joelbrs.jpawebservice.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO implements Serializable {
    private Long id;
    private Instant moment;
    private Long orderStatus;
    private User client;
    private Set<OrderItem> items = new HashSet<>();
    private Payment payment;

    public OrderDTO() {}

    public OrderDTO(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderDTO(Order order) {
        setItems(order.getItems());
        setClient(order.getClient());
        setId(order.getId());
        setMoment(order.getMoment());
        setOrderStatus(order.getOrderStatus());
        setPayment(order.getPayment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }
    public Set<OrderItem> getItems() {
        return Collections.unmodifiableSet(items);
    }
    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        return items.stream().mapToDouble(OrderItem::getSubTotal).sum();
    }

}

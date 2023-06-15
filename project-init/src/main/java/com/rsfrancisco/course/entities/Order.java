package com.rsfrancisco.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsfrancisco.course.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdAt;

    private Integer orderStatus;

    // propriedade associativa
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client = new User();

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {}
    public Order(Long id, Instant createdAt, User client, OrderStatus orderStatus) {
        this.id = id;
        this.client = client;
        this.createdAt = createdAt;
        setOrderStatus(orderStatus);
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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
            this.orderStatus = orderStatus.getEnumCode();
        }
    }


    public Set<OrderItem> getItems() {
        return items;
    }


    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public Double getTotal() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(createdAt, order.createdAt) &&
                Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, client);
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + client +
                '}';
    }
}
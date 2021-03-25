package com.maktab.models;

import com.maktab.enums.OrderStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class HistoryOrder {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Date")
    private Timestamp date;
    @Column(name = "Order Status")
    private OrderStatus orderStatus;
    @Column(name = "Order Serial Number")
    private String serialNumber;
    @Column(name = "Clerk First Name")
    private String clerkFirstName;
    @Column(name = "Clerk Last Name")
    private String clerkLastName;
    @Column(name = "Comment")
    private String comment;

    public HistoryOrder() {
    }

    public HistoryOrder(OrderStatus orderStatus, String serialNumber, String clerkFirstName, String clerkLastName, String comment) {
        this.orderStatus = orderStatus;
        this.serialNumber = serialNumber;
        this.clerkFirstName = clerkFirstName;
        this.clerkLastName = clerkLastName;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClerkFirstName() {
        return clerkFirstName;
    }

    public void setClerkFirstName(String clerkFirstName) {
        this.clerkFirstName = clerkFirstName;
    }

    public String getClerkLastName() {
        return clerkLastName;
    }

    public void setClerkLastName(String clerkLastName) {
        this.clerkLastName = clerkLastName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

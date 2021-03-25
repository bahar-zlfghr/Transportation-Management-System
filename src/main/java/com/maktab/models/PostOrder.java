package com.maktab.models;

import com.maktab.enums.OrderStatus;
import com.maktab.enums.TransportType;

import javax.persistence.*;

@Entity
public class PostOrder implements CalculatePostPrice {
    @Id
    @Column(name = "SerialNumber", length = 5)
    private int serialNumber;
    @OneToOne
    @JoinColumn(name = "Origin_Id")
    private Address originAddress;
    @OneToOne
    @JoinColumn(name = "Destination_Id")
    private Address destinationAddress;
    @OneToOne
    @JoinColumn(name = "Recipient_Id")
    private Recipient recipient;
    @Column(name = "TransportType", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
    @OneToOne
    @JoinColumn(name = "ParcelPost_Id")
    private ParcelPost parcelPost;
    @Column(name = "Order_Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "DeliverTime", nullable = false, length = 1)
    private int deliverTime;

    public PostOrder() {
    }

    public PostOrder(int serialNumber, Address originAddress, Address destinationAddress, Recipient recipient, TransportType transportType, ParcelPost parcelPost, OrderStatus status) {
        this.serialNumber = serialNumber;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.recipient = recipient;
        this.transportType = transportType;
        this.parcelPost = parcelPost;
        this.status = status;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Address getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(Address originAddress) {
        this.originAddress = originAddress;
    }

    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(Address destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public ParcelPost getParcelPost() {
        return parcelPost;
    }

    public void setParcelPost(ParcelPost parcelPost) {
        this.parcelPost = parcelPost;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public void calculatePremiumTransportPrice() {
        price = parcelPost.getWeight() * 20_000.0;
        deliverTime = 1;
    }

    @Override
    public void calculateGoldTransportPrice() {
        price = parcelPost.getWeight() * 14_000.0;
        deliverTime = 3;
    }

    @Override
    public void calculateSilverTransportPrice() {
        price = parcelPost.getWeight() * 10_000.0;
        deliverTime = 4;
    }
}

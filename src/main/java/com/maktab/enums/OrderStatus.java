package com.maktab.enums;

public enum OrderStatus {
    REGISTERED("Registered"), ACCEPTED("Accepted"), SENDING("Sending"), DELIVERED("Delivered");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

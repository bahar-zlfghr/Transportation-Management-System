package com.maktab.repositories;

import com.maktab.models.PostOrder;

import java.util.ArrayList;
import java.util.List;

public class PostOrderRepository {
    private static final List<PostOrder> orders = new ArrayList<>();

    public void addOrder(PostOrder order) {
        orders.add(order);
    }

    public void addOrders(List<PostOrder> orders) {
        PostOrderRepository.orders.addAll(orders);
    }

    public static List<PostOrder> getOrders() {
        return orders;
    }

    public boolean existsSerialNumber(int serialNumber) {
        return orders.stream().filter(customer -> customer.getSerialNumber() ==serialNumber).count() == 1;
    }
}

package com.rsfrancisco.course.entities.enums;

import com.rsfrancisco.course.entities.Order;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int enumCode;
    private OrderStatus(int enumCode) {
        this.enumCode = enumCode;
    }

    public int getEnumCode() {
        return enumCode;
    }

    public static OrderStatus valueOf(int enumCode) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getEnumCode() == enumCode)
                return value;
        }
        throw new IllegalArgumentException("Invalid OrderStatus enumCode");
    }
}

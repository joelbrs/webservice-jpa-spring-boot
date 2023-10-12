package br.com.joelbrs.jpawebservice.enums;

import java.util.Objects;

public enum OrderStatus {
    WAITING_PAYMENT(1L),
    PAID(2L),
    SHIPPED(3L),
    DELIVERED(4L),
    CANCELED(5L);

    private Long code;

    OrderStatus(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public static OrderStatus valueOf(Long code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (Objects.equals(status.getCode(), code)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid OrderStatus code!");
    }
}

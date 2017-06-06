package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    void insert(String orderId, OrderItem orderItem);

    List<OrderItem> findByOrderId(String anOrderId);
}

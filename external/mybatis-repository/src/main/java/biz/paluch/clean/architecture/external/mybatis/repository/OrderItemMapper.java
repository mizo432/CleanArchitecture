package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.OrderItem;

public interface OrderItemMapper {
    void insert(String orderId, OrderItem orderItem);
}

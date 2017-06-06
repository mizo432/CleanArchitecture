package biz.paluch.clean.architecture.contracts.repositories;

import biz.paluch.clean.architecture.applicationmodel.Order;

import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 07:26
 */
public interface OrderRepository {
    int getNextOrderId();

    void persist(Order order);

    List<Order> findOrders();

    Order find(String orderId);
}

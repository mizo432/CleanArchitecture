package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.applicationmodel.OrderItem;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import jp.or.venuspj.utils.Objects2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisOrderRepository implements OrderRepository {

    OrderMapper orderMapper;
    OrderItemMapper orderItemMapper;

    @Autowired
    public MybatisOrderRepository(OrderMapper anOrderMapper, OrderItemMapper anOrderItemMapper) {
        orderMapper = anOrderMapper;
        orderItemMapper = anOrderItemMapper;

    }

    @Override
    public int getNextOrderId() {
        return orderMapper.getNextOrderId();
    }

    @Override
    public void persist(Order anOrder) {
        orderMapper.insert(anOrder);
        for (OrderItem orderItem : anOrder.items()) {
            orderItemMapper.insert(anOrder.orderId(), orderItem);
        }
    }

    @Override
    public List<Order> findOrders() {
        return orderMapper.findAll();
    }

    @Override
    public Order find(String anOrderId) {
        Order order = orderMapper.findOne(anOrderId);
        if (Objects2.nonNull(order))
            return new Order(order.orderId(),
                    order.orderDate(),
                    orderItemMapper.findByOrderId(anOrderId),
                    order.createdBy());
        throw new NotFoundException("Order is not found orderId:" + anOrderId);
    }
}

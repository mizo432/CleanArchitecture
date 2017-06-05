package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.applicationmodel.OrderItem;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisOrderRepository implements OrderRepository {

    OrderMapper orderMapper;
    OrderItemMapper orderItemMapper;

    public MyBatisOrderRepository(OrderMapper anOrderMapper) {
        orderMapper = anOrderMapper;

    }

    @Override
    public int getNextOrderId() {
        return orderMapper.getNextOrderId();
    }

    @Override
    public void persist(Order anOrder) {
        orderMapper.insert(anOrder);
        for (OrderItem orderItem : anOrder.getItems()) {
            orderItemMapper.insert(anOrder.getOrderId(), orderItem);
        }
    }

    @Override
    public List<Order> findOrders() {
        return orderMapper.findAll();
    }
}

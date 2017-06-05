package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisOrderRepository implements OrderRepository {
    OrderMapper orderMapper;

    public MyBatisOrderRepository(OrderMapper anOrderMapper) {
        orderMapper = anOrderMapper;

    }

    @Override
    public int getNextOrderId() {
        return 0;
    }

    @Override
    public void persist(Order order) {

    }

    @Override
    public List<Order> findOrders() {
        return null;
    }
}

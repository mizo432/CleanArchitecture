package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.applicationmodel.User;
import jp.or.venuspj.utils.Lists2;
import jp.or.venuspj.utils.Maps2;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderMapperMock implements OrderMapper {
    public static final OrderMapper defaultMock(){
        return new OrderMapperMock();
    }

    Map<String, Order> map = Maps2.newHashMap();

    private OrderMapperMock() {
        map.put("mark-41", new Order("mark-41", LocalDate.now(), Lists2.newArrayList(), new User("mark")));
    }

    @Override
    public void insert(Order anOrder) {
        map.put(anOrder.orderId(), anOrder);

    }

    @Override
    public int getNextOrderId() {
        return 1;
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = Lists2.newArrayList();
        for (Order order : map.values())
            result.add(order);
        return result;
    }

    @Override
    public Order findOne(String anOrderId) {
        return map.get(anOrderId);
    }
}

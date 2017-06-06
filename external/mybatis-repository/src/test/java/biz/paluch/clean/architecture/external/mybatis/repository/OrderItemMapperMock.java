package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.OrderItem;
import jp.or.venuspj.utils.Lists2;
import jp.or.venuspj.utils.Maps2;
import jp.or.venuspj.utils.Objects2;

import java.util.List;
import java.util.Map;

public final class OrderItemMapperMock implements OrderItemMapper {
    public static final OrderItemMapper defaultMock(){
      return new OrderItemMapperMock();
    }

    Map<String, List<OrderItem>> map = Maps2.newHashMap();

    private OrderItemMapperMock() {
        map.put("mark-41", Lists2.newArrayList(new OrderItem("A"), new OrderItem("B"), new OrderItem("C")));
    }

    @Override
    public void insert(String orderId, OrderItem orderItem) {
        List<OrderItem> list = map.get(orderId);
        if (Objects2.isNull(list)) {
            list = Lists2.newArrayList();
            map.put(orderId, list);
        }
        list.add(orderItem);
    }

    @Override
    public List<OrderItem> findByOrderId(String anOrderId) {
        List<OrderItem> list = map.get(anOrderId);
        if (Objects2.isNull(list)) {
            list = Lists2.newArrayList();
            map.put(anOrderId, list);
        }
        return list;
    }
}

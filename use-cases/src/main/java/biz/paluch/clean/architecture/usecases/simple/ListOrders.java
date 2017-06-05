package biz.paluch.clean.architecture.usecases.simple;

import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 07:22
 */
@Component
public class ListOrders {
    private OrderRepository orderRepository;

    @Autowired
    public ListOrders(OrderRepository anOrderRepository){
        orderRepository = anOrderRepository;
    }

    public List<Order> listOrders() {
        return orderRepository.findOrders();
    }

}

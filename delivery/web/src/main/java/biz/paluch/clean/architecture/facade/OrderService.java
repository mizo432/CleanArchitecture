package biz.paluch.clean.architecture.facade;

import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import biz.paluch.clean.architecture.contracts.repositories.UserRepository;
import biz.paluch.clean.architecture.contracts.usecases.PlaceOrderOutput;
import biz.paluch.clean.architecture.contracts.usecases.PlaceOrderRequest;
import biz.paluch.clean.architecture.di_example.PlaceOrderWithDependencies;
import biz.paluch.clean.architecture.usecases.simple.CreateOrUpdateUser;
import biz.paluch.clean.architecture.usecases.simple.ListOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 02.08.13 12:45
 */
@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CreateOrUpdateUser createOrUpdateUser;

    @Autowired
    private ListOrders listOrders;

    @Autowired
    private PlaceOrderWithDependencies placeOrder;

    public List<Order> listOrders() {
        return listOrders.listOrders();
    }

    public String placeOrder(List<String> items, String userName) throws NotFoundException {
        createOrUpdateUser.createOrUpdateUser(userName);

        PlaceOrderRequest request = new PlaceOrderRequest();
        request.items = items;
        request.userName = userName;

        PlaceOrderResponse response = new PlaceOrderResponse();

        placeOrder.placeOrder(request, response);

        return response.orderId;
    }

    private static class PlaceOrderResponse implements PlaceOrderOutput {
        public String orderId;

        @Override
        public void onResponse(String orderId) {
            this.orderId = orderId;
        }
    }
}

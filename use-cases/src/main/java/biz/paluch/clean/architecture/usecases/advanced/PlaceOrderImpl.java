package biz.paluch.clean.architecture.usecases.advanced;

import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.applicationmodel.OrderItem;
import biz.paluch.clean.architecture.commons.DateProvider;
import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import biz.paluch.clean.architecture.contracts.repositories.UserRepository;
import biz.paluch.clean.architecture.contracts.usecases.PlaceOrder;
import biz.paluch.clean.architecture.contracts.usecases.PlaceOrderOutput;
import biz.paluch.clean.architecture.contracts.usecases.PlaceOrderRequest;
import biz.paluch.clean.architecture.usecases.simple.ValidateOrder;
import jp.or.venuspj.utils.Lists2;

import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 07:15
 */
public class PlaceOrderImpl implements PlaceOrder {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    /**
     * Place order and return the OrderId.
     */
    @Override
    public void placeOrder(PlaceOrderRequest request, PlaceOrderOutput output) throws NotFoundException {

        ValidateOrder.newInstance(itemRepository, userRepository).validate(request.items, request.userName);

        String orderId = createOrderId(request.userName);

        Order order = constructOrder(orderId, request.items, request.userName);

        storeOrder(order);

        output.onResponse(order.orderId());
    }

    private String createOrderId(String userName) {
        int nextOrderId = orderRepository.getNextOrderId();
        return userName + "-" + nextOrderId;
    }

    private Order constructOrder(String orderId, List<String> items, String userName) {
        Order order = new Order(orderId,
                DateProvider.get(),
                Lists2.newArrayList(),
                userRepository.find(userName));

        for (String item : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderItem(item);
            order.items().add(orderItem);
        }

        return order;
    }

    private void storeOrder(Order order) {
        orderRepository.persist(order);
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

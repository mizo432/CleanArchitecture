package biz.paluch.clean.architecture.di_example;

import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import biz.paluch.clean.architecture.contracts.repositories.OrderRepository;
import biz.paluch.clean.architecture.contracts.repositories.UserRepository;
import biz.paluch.clean.architecture.usecases.advanced.PlaceOrderImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This Use-Case wrapper extends the {@link PlaceOrderImpl} use case class in order to use declarative dependency injection.
 * 
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 */
public class PlaceOrderWithDependencies extends PlaceOrderImpl {

    @Autowired
    @Override
    public void setOrderRepository(OrderRepository orderRepository) {
        super.setOrderRepository(orderRepository);
    }

    @Autowired
    @Override
    public void setItemRepository(ItemRepository itemRepository) {
        super.setItemRepository(itemRepository);
    }

    @Autowired
    @Override
    public void setUserRepository(UserRepository userRepository) {
        super.setUserRepository(userRepository);
    }
}

package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Order;
import biz.paluch.clean.architecture.applicationmodel.OrderItem;
import biz.paluch.clean.architecture.applicationmodel.User;
import jp.or.venuspj.utils.Lists2;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MybatisOrderRepositoryTest {
    private MybatisUserRepository mybatisUserRepository;
    private MybatisOrderRepository mybatisOrderRepository;

    @Before
    public void before() throws Exception {
        UserMapper userMapper = createUserMapper();
        mybatisUserRepository = new MybatisUserRepository(userMapper);
        OrderMapper orderMapper = OrderMapperMock.defaultMock();
        OrderItemMapper orderItemMapper = OrderItemMapperMock.defaultMock();
        mybatisOrderRepository = new MybatisOrderRepository(orderMapper, orderItemMapper);
    }

    private UserMapper createUserMapper() {
        return new UserMapper() {
            @Override
            public User find(String anUserName) {
                return null;
            }

            @Override
            public void insert(User anUser) {

            }
        };
    }

    @Test
    public void testGetNextOrderId() throws Exception {
        int result = mybatisOrderRepository.getNextOrderId();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testPersistAndFind() throws Exception {
        mybatisUserRepository.store(new User("mark"));

        Order order = mockOrder();

        mybatisOrderRepository.persist(order);

    }

    private Order mockOrder() {
        Order order = new Order("mark-42",
                LocalDate.now(),
                Lists2.newArrayList(new OrderItem("A"),
                        new OrderItem("B"),
                        new OrderItem("C"))
                , new User("mark"));
        return order;
    }

    @Test
    public void testFind() throws Exception {

        Order order = mockOrder();
        createOrder(order);

        Order result = mybatisOrderRepository.find(order.getOrderId());

        assertThat(result.createdBy().getUserName())
                .isEqualTo(order.createdBy().getUserName());
        assertThat(result.orderId())
                .isEqualTo(order.orderId());
        assertThat(result.items().size())
                .isEqualTo(order.items().size());
    }

    @Test
    public void testFindOrders() throws Exception {
        List<Order> result = mybatisOrderRepository.findOrders();
        assertThat(result.size())
                .isEqualTo(1);

    }

    private void createOrder(Order order) {

        mybatisUserRepository.store(new User("mark"));
        mybatisOrderRepository.persist(order);
    }
}

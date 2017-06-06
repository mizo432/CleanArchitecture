package biz.paluch.clean.architecture.applicationmodel;

import jp.or.venuspj.utils.Lists2;

import java.time.LocalDate;
import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 07:23
 */
public class Order {
    private String orderId;
    private LocalDate orderDate;

    private List<OrderItem> items = Lists2.newArrayList();
    ;
    private User createdBy;

    Order() {

    }

    public Order(String anOrderId, LocalDate anOrderDate, List<OrderItem> anItems, User aCreatedBy) {
        orderId = anOrderId;
        orderDate = anOrderDate;
        items = anItems;
        createdBy = aCreatedBy;

    }

    @Deprecated
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Deprecated
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Deprecated
    public List<OrderItem> getItems() {
        return items;
    }

    @Deprecated
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate orderDate() {
        return orderDate;
    }

    public String orderId() {
        return orderId;
    }

    public List<OrderItem> items() {
        return items;
    }

    public User createdBy() {
        return createdBy;
    }
}

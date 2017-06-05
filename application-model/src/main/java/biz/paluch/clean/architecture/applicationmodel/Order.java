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

    private List<OrderItem> items = Lists2.newArrayList();;
    private User createdBy;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}

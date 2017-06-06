package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insert(Order anOrder);

    int getNextOrderId();

    List<Order> findAll();

    Order findOne(String anOrderId);
}

package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User find(String anUserName);

    void insert(@Param("anUser") User anUser);
}


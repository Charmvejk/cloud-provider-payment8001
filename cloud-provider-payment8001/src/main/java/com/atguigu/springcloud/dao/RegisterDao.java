package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RegisterDao {
    int register(Register register);

    List<Register> getAllUser(@Param("name") String name);

    Register getPaymentById(@Param("id") Long id);

    int modifyPwd(Register register);
}


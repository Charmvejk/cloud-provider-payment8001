package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Register;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterService {
    int register(Register register);

    List<Register> getAllUser(@Param("name") String name);

    int modifyPwd(Register register);

    Register getPaymentById(@Param("id") Long id);
}



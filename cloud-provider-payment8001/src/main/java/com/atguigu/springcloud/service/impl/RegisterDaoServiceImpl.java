package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.RegisterDao;
import com.atguigu.springcloud.entities.Register;
import com.atguigu.springcloud.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("registerService")
public class RegisterDaoServiceImpl implements RegisterService {
    @Resource
    private RegisterDao registerDao;

    @Override
    public int register(Register register) {
        return registerDao.register(register);
    }

    @Override
    public List<Register> getAllUser(String name) {
        return registerDao.getAllUser(name);
    }

    @Override
    public int modifyPwd(Register register) {
        return registerDao.modifyPwd(register);
    }

    @Override
    public Register getPaymentById(Long id) {
        return registerDao.getPaymentById(id);
    }
}



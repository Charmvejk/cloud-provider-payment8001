package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * /**
 * Created by wsy on 2021/4/17 14:24.
 * e-mail : svipwsy@163.com
 * desc:
 */

@Data
@AllArgsConstructor  // 有参构造函数
@NoArgsConstructor //无参函数
public class Register implements Serializable { //为对象提供标准的序列化与反序列化操作
    private int id;

    /**
     * 注册中心
     */
    private String name;
    private String enterprise;
    private String phone;
    private String password;

}
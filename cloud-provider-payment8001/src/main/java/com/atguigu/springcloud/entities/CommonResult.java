package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * /**
 * Created by wsy on 2021/4/17 14:24.
 * e-mail : svipwsy@163.com
 * desc:
 */

@Data //lombok 自动生成getset
@AllArgsConstructor  // 有参构造函数
@NoArgsConstructor //无参函数
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T     data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}

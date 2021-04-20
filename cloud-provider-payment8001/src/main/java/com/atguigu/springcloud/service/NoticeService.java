package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Notice;
import com.atguigu.springcloud.entities.Register;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NoticeService {


    List<Notice> getMsg( Map<String,Integer> map);
    List<Notice> getTotalMsg();
}



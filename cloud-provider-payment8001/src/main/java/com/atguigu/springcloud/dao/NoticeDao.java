package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Notice;
import com.atguigu.springcloud.entities.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeDao {

    List<Notice> getMsg(Map<String, Integer> map);

    List<Notice> getTotalMsg();
}


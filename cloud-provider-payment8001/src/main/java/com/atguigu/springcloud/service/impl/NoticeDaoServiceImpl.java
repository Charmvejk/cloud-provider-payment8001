package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.NoticeDao;
import com.atguigu.springcloud.dao.RegisterDao;
import com.atguigu.springcloud.entities.Notice;
import com.atguigu.springcloud.entities.Register;
import com.atguigu.springcloud.service.NoticeService;
import com.atguigu.springcloud.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeDaoServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;


    @Override
    public List<Notice> getMsg(Map<String, Integer> map) {
        return noticeDao.getMsg(map);
    }

    @Override
    public List<Notice> getTotalMsg() {
        return noticeDao.getTotalMsg();
    }
}



package com.atguigu.springcloud.controller;

/*
 *通知信息
 * */

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Notice;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.Register;
import com.atguigu.springcloud.service.NoticeService;
import com.atguigu.springcloud.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/service")
public class NoticeController {

    @Resource
    private NoticeService noticeService;


    @PostMapping(value = "/find/notice")
    public PageResult notice(@RequestBody Map<String, Integer> notice) {

        int currentPage = notice.get("currentPage");//当前是第几页
        int pageSize = notice.get("pageSize"); //页面大小
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("currentPage", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);

        List<Notice> getMsg = noticeService.getMsg(map);

        return new PageResult(200, getMsg.size(),notice.get("currentPage"),noticeService.getTotalMsg().size(),"请求成功", getMsg);

    }

}



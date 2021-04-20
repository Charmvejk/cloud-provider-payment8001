package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Register;
import com.atguigu.springcloud.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
 *注册信息
 * */

@Slf4j
@RestController
@RequestMapping("/service")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody Register register) {
        List<Register> getUserInfo = registerService.getAllUser(register.getName());
        if (getUserInfo.size() != 1) {
            int result = registerService.register(register);

            log.info("****=插入结果：" + result);
            if (result > 0) {
                return new CommonResult(200, "插入数据库成功，端口号为：" + serverPort, result);
            } else {
                return new CommonResult(444, "插入数据库失败", null);
            }
        } else {
            return new CommonResult(200, "该用户已注册" + serverPort, getUserInfo);
        }

    }

    @PostMapping(value = "/modify/pwd")
    public CommonResult update(@RequestBody Register register) {
        int modifyInfo = registerService.modifyPwd(register);

        if (modifyInfo == 1) {
            return new CommonResult(200, "密码已重置", null);
        } else {
            return new CommonResult(500, "用户不存在", null);
        }
    }


/*    //通过id进行查询
    @GetMapping("/get/{id}")
    public CommonResult<Register> getPaymentById(@PathVariable("id") Long id) {
        Register register = registerService.getPaymentById(id);
        log.info("****查询结果：" + register);
        if (register != null) {
            return new CommonResult(200, "查询成功，端口号为：" + serverPort, register);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }*/

/*
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***********service:" + service);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstances) {
            log.info(serviceInstance.getHost() + "\t" + serviceInstance.getInstanceId() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/zipkin")
    public String paymentZipKin() {
        return "哈哈哈哈哈哈哈哈哈哈哈哈哈哈！！！";
    }
*/

}



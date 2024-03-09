package com.atguigu.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1. 想要远程调用别的服务
 * 1）引入open-feign
 * 2）编写一个借口，告诉springcloud这个结构需要调用远程服务
 *  1. 声明接口的每一个方法都是调用哪个远程服务的哪个请求
 * 3）开启远程调用功能
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages =  "com.atguigu.gulimall.member.feign")
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}

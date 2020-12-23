package org.goj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author CK
 * @date 2020/12/1 15:06
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.goj.feign.feign")
@MapperScan({"org.goj.user.mapper"})
@SpringBootApplication
@EnableTransactionManagement
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}

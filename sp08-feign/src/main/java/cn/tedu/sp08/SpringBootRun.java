package cn.tedu.sp08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/28 9:31
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

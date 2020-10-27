package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/27 11:09
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringBootApplication
@EnableHystrixDashboard
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

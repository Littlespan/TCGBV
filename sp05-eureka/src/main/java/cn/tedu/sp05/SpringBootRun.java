package cn.tedu.sp05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 17:01
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringBootRun {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

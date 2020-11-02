package cn.tedu.sp12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/30 17:16
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

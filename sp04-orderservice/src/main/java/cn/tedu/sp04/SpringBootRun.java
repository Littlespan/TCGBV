package cn.tedu.sp04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 15:41
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringCloudApplication
@EnableFeignClients
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

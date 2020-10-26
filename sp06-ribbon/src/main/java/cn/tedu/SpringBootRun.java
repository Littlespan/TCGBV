package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/26 11:45
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@SpringBootApplication
public class SpringBootRun {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

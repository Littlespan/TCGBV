package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/26 11:45
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
//@SpringBootApplication
//@EnableCircuitBreaker
@SpringCloudApplication
public class SpringBootRun {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory= new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(1000);
        simpleClientHttpRequestFactory.setReadTimeout(1000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}

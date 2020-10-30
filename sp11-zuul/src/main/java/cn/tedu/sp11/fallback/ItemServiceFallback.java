package cn.tedu.sp11.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/30 11:36
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Slf4j
@Component
public class ItemServiceFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        //当执行item-service失败，
        //应用当前这个降级类
        return "item-service";
//        return "*";
        //星号和null都表示所有微服务失败都应用当前降级类
        //"*"; //null;
    }

    //该方法返回封装降级响应的对象
    //ClientHttpResponse中封装降级响应
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return getClientHttpResponse();
    }

    private ClientHttpResponse getClientHttpResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                log.info("fallback body");
                String s = JsonResult.err().msg("后台服务错误").toString();
                return new ByteArrayInputStream(s.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}

package cn.tedu.sp06.Controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/26 11:47
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@RestController
@Slf4j
public class RibboController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        return restTemplate.getForObject("http://item-service/{1}",JsonResult.class,orderId);

    }
    @PostMapping("/item-service/decreaseNumber")
    public JsonResult<?> decreaseNumber(@RequestBody List<Item> items) {
        //发送 post 请求
        return restTemplate.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
    }

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return restTemplate.getForObject("http://user-service/{1}", JsonResult.class, userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult<?> addScore(
            @PathVariable Integer userId, Integer score) {
        return restTemplate.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
    }

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return restTemplate.getForObject("http://order-service/{1}", JsonResult.class, orderId);
    }

    @GetMapping("/order-service")
    public JsonResult<?> addOrder() {
        return restTemplate.getForObject("http://order-service/", JsonResult.class);
    }
}

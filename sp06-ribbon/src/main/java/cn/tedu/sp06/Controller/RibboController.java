package cn.tedu.sp06.Controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getItemsFB")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        return restTemplate.getForObject("http://item-service/{1}",JsonResult.class,orderId);
    }
    public JsonResult<List<Item>> getItemsFB(String orderId) {
        return JsonResult.err("获取订单商品列表失败");
    }

    @PostMapping("/item-service/decreaseNumber")
    @HystrixCommand(fallbackMethod = "decreaseNumberFB")
    public JsonResult<?> decreaseNumber(@RequestBody List<Item> items) {
        //发送 post 请求
        return restTemplate.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
    }
    public JsonResult<?> decreaseNumberFB(List<Item> items) {
        return JsonResult.err("更新商品库存失败");
    }

    @GetMapping("/user-service/{userId}")
    @HystrixCommand(fallbackMethod = "getUserFB")
    public JsonResult<?> getUser(@PathVariable Integer userId) {
        return restTemplate.getForObject("http://user-service/{1}", JsonResult.class, userId);
    }
    public JsonResult<?> getUserFB(Integer userId) {
        return JsonResult.err("获取用户信息失败");
    }

    @GetMapping("/user-service/{userId}/score")
    @HystrixCommand(fallbackMethod = "addScoreFB")
    public JsonResult<?> addScore(
            @PathVariable Integer userId, Integer score) {
        return restTemplate.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
    }
    public JsonResult<?> addScoreFB(Integer userId, Integer score) {
        return JsonResult.err("增加用户积分失败");
    }

    @GetMapping("/order-service/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrderFB")
    public JsonResult<?> getOrder(@PathVariable String orderId) {
        return restTemplate.getForObject("http://order-service/{1}", JsonResult.class, orderId);
    }
    public JsonResult<?> getOrderFB(String orderId) {
        return JsonResult.err("获取订单失败");
    }

    @GetMapping("/order-service")
    @HystrixCommand(fallbackMethod = "addOrderFB")
    public JsonResult<?> addOrder() {
        return restTemplate.getForObject("http://order-service/", JsonResult.class);
    }
    public JsonResult<?> addOrderFB() {
        return JsonResult.err("添加订单失败");
    }
}

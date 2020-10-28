package cn.tedu.sp08.Controller;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/28 9:39
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */

import cn.tedu.sp08.Service.ItemFeignService;
import cn.tedu.sp08.Service.OrderFeignService;
import cn.tedu.sp08.Service.UserFeignService;
import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp08.Service.OrderFeignService;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FeignController {
    @Autowired
    private ItemFeignService itemService;
    @Autowired
    private UserFeignService userService;
    @Autowired
    private OrderFeignService orderService;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return itemService.getItems(orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return itemService.decreaseNumber(items);
    }


    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        return userService.addScore(userId, score);
    }


    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return orderService.addOrder();
    }
}

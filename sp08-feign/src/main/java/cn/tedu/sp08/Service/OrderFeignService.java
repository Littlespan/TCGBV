package cn.tedu.sp08.Service;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service", fallback = OrderFeignServiceFB.class)
public interface OrderFeignService {

    @GetMapping("/{orderId}")
    JsonResult<Order> getOrder(@PathVariable String orderId);

    @GetMapping("/")
    JsonResult addOrder();

}
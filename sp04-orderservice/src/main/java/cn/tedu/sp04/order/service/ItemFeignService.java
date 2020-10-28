package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(fallback = ItemFeignServiceFB.class , name = "item-service")
public interface ItemFeignService {

    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items);
}

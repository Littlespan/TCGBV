package cn.tedu.sp08.Service;


import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import com.fasterxml.jackson.core.json.JsonReadContext;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "item-service", fallback = itemFeignServiceFB.class)
public interface ItemFeignService {

    @GetMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @PostMapping("/decreaseNumber")
    JsonResult decreaseNumber(@RequestBody List<Item> items);

}

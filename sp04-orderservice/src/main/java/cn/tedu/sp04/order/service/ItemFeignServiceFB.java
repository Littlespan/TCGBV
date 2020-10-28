package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/28 14:35
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Component
public class ItemFeignServiceFB implements ItemFeignService{
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        if(Math.random()<0.5) {
            return JsonResult.ok().data(

                    Arrays.asList(new Item(1,"缓存aaa",2),
                            new Item(2,"缓存bbb",1),
                            new Item(3,"缓存ccc",3),
                            new Item(4,"缓存ddd",1),
                            new Item(5,"缓存eee",5))

            );
        }
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }
}

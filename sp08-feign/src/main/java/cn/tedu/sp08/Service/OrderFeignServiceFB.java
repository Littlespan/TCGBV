package cn.tedu.sp08.Service;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/28 9:56
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Component
public class OrderFeignServiceFB implements OrderFeignService{
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取商品订单");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法保存订单");
    }
}

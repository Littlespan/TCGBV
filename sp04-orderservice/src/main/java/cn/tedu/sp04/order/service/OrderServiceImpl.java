package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 15:42
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ItemFeignService itemFeignService;
    @Autowired
    private UserFeignService userFeignService;

    @Override
    public Order getOrder(String orderId) {
        //调用user-service获取用户信息
        JsonResult<User> user = userFeignService.getUser(7);

        //调用item-service获取商品信息
        JsonResult<List<Item>> items = itemFeignService.getItems(orderId);


        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    @Override
    public void addOrder(Order order) {
        //调用item-service减少商品库存
        itemFeignService.decreaseNumber(order.getItems());

        //TODO: 调用user-service增加用户积分
        userFeignService.addScore(7, 100);

        log.info("保存订单："+ order);
    }
}

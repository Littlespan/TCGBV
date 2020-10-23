package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 15:42
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrder(String orderId) {
        Order order = new Order();
        order.setId(orderId);
        return order;
    }

    @Override
    public void addOrder(Order order) {
        log.info("保存订单："+ order);
    }
}

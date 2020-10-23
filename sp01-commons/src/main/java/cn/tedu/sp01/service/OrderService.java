package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Order;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:35
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
public interface OrderService {
    Order getOrder(String orderId);
    void addOrder(Order order);
}


package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Item;

import java.util.List;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:33
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
public interface ItemService {
    List<Item> getItems(String orderId);
    void decreaseNumbers(List<Item> list);
}

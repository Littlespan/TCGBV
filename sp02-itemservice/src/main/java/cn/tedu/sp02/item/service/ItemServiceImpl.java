package cn.tedu.sp02.item.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:54
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> getItems(String orderId) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item(1, "商品 1",1));
        list.add(new Item(2, "商品 2",2));
        list.add(new Item(3, "商品 3",3));
        list.add(new Item(4, "商品 4",4));
        list.add(new Item(5, "商品 5",5));
        return list;
    }

    @Override
    public void decreaseNumbers(List<Item> list) {
        for(Item item : list) {
            log.info("减少库存 - "+item);
        }
    }
}

package cn.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:11
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;
    private String name;
    private Integer number;
}

package cn.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:12
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}
package cn.tedu.sp01.service;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 10:35
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
import cn.tedu.sp01.pojo.User;

public interface UserService {
    User getUser(Integer id);
    void addScore(Integer id, Integer score);
}

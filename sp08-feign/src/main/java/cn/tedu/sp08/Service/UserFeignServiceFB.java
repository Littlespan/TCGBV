package cn.tedu.sp08.Service;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/28 9:55
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Component
public class UserFeignServiceFB implements UserFeignService{
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }
}

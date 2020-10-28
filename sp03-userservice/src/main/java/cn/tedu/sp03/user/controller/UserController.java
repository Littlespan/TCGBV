package cn.tedu.sp03.user.controller;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/23 14:46
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        log.info("get user, userId=" + userId);
        User u = userService.getUser(userId);
        return JsonResult.ok(u);
    }

    @GetMapping("/{userId}/score")
    public JsonResult<?> addScore(
            @PathVariable Integer userId, Integer score) {
        userService.addScore(userId, score);
        return JsonResult.ok();
    }
}

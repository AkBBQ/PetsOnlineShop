package com.pet.shop.serviceimpl;

import com.pet.shop.mapper.UserMapper;
import com.pet.shop.pojo.User;
import com.pet.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户服务实现
 *
 * @author 昂太 (angtai@maihaoche.com)
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int login(User user) {
        //判断成功与否的标志 0,成功,1,用户名或者密码错误
        int flag = 0;

        //接收登录查询的对象
        User queryUser = new User();
        try {
             queryUser = userMapper.login(user);
            if (Objects.isNull(queryUser)) {
                log.error("没有该用户");
                flag = 1;
            } else {
                if (queryUser.getPwd().equals(user.getPwd())) {
                    flag = 0;
                } else {
                    log.error("密码错误");
                    flag = 1;
                }
            }
        } catch (Exception e) {
            log.error("登录查询失败");
            e.printStackTrace();
        }
        return flag;
    }
}

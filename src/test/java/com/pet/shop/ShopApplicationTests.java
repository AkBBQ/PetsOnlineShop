package com.pet.shop;

import com.pet.shop.mapper.UserMapper;
import com.pet.shop.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setPhone("15251800012");
        System.out.println(userMapper.login(user).toString());
    }

}

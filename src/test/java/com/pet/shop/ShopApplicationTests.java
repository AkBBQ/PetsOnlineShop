package com.pet.shop;

import com.pet.shop.mapper.SecondTitleMapper;
import com.pet.shop.mapper.UserMapper;
import com.pet.shop.pojo.SecondTitle;
import com.pet.shop.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SecondTitleMapper secondTitleMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setPhone("15251800012");
        System.out.println(userMapper.login(user).toString());
    }

    @Test
    public void test(){
        List<SecondTitle> secondTitles = secondTitleMapper.queryAll();
        System.out.println(secondTitles.toString());
    }

    /**
     * 模糊查询测试
     */
    @Test
    public void test2(){
        List<SecondTitle> ss = secondTitleMapper.queryByName("宠");
        System.out.println(ss.toString());
    }

}

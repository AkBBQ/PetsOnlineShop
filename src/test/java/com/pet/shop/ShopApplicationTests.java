package com.pet.shop;

import com.pet.shop.mapper.GoodsMapper;
import com.pet.shop.mapper.SecondTitleMapper;
import com.pet.shop.mapper.UserMapper;
import com.pet.shop.model.Goods;
import com.pet.shop.model.SecondTitle;
import com.pet.shop.model.User;
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
    private UserMapper userMapper;

    @Autowired
    private SecondTitleMapper secondTitleMapper;

    @Autowired
    private GoodsMapper goodsMapper;

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

    /**
     * 复杂sql查询
     */
    @Test
    public void tes(){
        Goods goods = new Goods();
        List<Goods> goods1 = goodsMapper.queryAllgoods(goods);
        System.out.println(goods1.toString());
    }

    @Test
    public void addGood(){
        Goods goods = new Goods();
        goods.setName("拉布拉多");
        goods.setPrice("1200");
        goods.setSupType(1);
        goods.setSubType(1);
        goods.setIsRecommend(1);
        goods.setSex(1);
        goods.setImage("拉布拉多的照片");
        goods.setAge(12);

        goodsMapper.addGood(goods);
    }

}

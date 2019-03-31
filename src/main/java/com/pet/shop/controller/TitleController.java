package com.pet.shop.controller;

import com.pet.shop.pojo.FirstTitle;
import com.pet.shop.pojo.SecondTitle;
import com.pet.shop.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 标题控制器
 * @author 昂太 (angtai@maihaoche.com)
 *
 */

@Controller
@RequestMapping("/Title")
public class TitleController {
    @Autowired
    TitleService titleService;


    /**
     * 新增一级标题
     * @param firstTitle
     */
    @ResponseBody
    @RequestMapping("/addFirst")
    public void addFirst(FirstTitle firstTitle){
        titleService.addFirst(firstTitle);
    }

    /**
     * 查询全部一级标题
     * @param
     */
    @RequestMapping("/queryAllFirst")
    public List<FirstTitle> queryAllFirst(){
        return titleService.queryAllFirst();
    }

    /**
     * 查询一级标题
     * @param
     */
    @RequestMapping("/queryFirst")
    public String queryFirst(Integer id,Model model){
         model.addAttribute("FirstTitle",titleService.queryOneFirst(id));
         return "admin/class";
    }

    /**
     * 修改前查询
     * @param id
     * @return
     */
    @GetMapping("/beforeUpdate")
    public String beforeUpdate(Integer id, Model model){
        model.addAttribute("info",titleService.queryOneSecond(id));
        return "admin/class-add";
    }

    /**
     * 修改一级标题
     * @param
     */
    @RequestMapping("/updateStatusFirst")
    public void updateStatusFirst(FirstTitle firstTitle){
         titleService.updateFirst(firstTitle);
    }

    /**
     * 根据ID删除
     * @param id
     */
    @RequestMapping("/deleteOneFirst")
    public void delete(Integer id){
        titleService.deleteOneFirst(id);
    }

    /**
     * 新增二级标题
     * @param secondTitle
     */
    @RequestMapping("/addSecond")
    public void addFitst(SecondTitle secondTitle){
        titleService.addSecond(secondTitle);
    }

    /**
     * 查询全部二级标题
     * @param
     */
    @RequestMapping("/queryAllSecond")
    public List<SecondTitle> queryAllSecond(){
        return titleService.queryAllSecond();
    }

    /**
     * 查询二级标题
     * @param
     */
    @RequestMapping("/querySecond")
    public SecondTitle querySecond(Integer id){
        return titleService.queryOneSecond(id);
    }

    /**
     * 修改二级标题
     * @param
     */
    @RequestMapping("/updateStatusSecond")
    public void updateStatusSecond(SecondTitle secondTitle){
        titleService.updateSecond(secondTitle);
    }


    /**
     * 根据ID删除
     * @param id
     */
    @RequestMapping("/deleteOneSecond")
    public void deleteOne(Integer id){
        titleService.deleteOneSecond(id);
    }
}
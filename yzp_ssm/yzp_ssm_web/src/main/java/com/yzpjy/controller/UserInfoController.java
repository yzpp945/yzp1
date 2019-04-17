package com.yzpjy.controller;

import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Product;
import com.yzpjy.domain.Role;
import com.yzpjy.domain.UserInfo;
import com.yzpjy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = false,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userInfoService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("userList",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findOne(@RequestParam(name = "id")String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userInfoService.findOne(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception{
        userInfoService.save(user);
        return "redirect:findAll.do";
    }

    /**
     * 用户关联角色
     */
    @RequestMapping("/addRoleToUser.do")
    public  ModelAndView addRoleToUser(@RequestParam String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userInfoService.findOne(id);
        List<Role> roles = userInfoService.unfind(id);
        mv.addObject("roleList",roles);
        mv.addObject("user",user);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRole.do")
    public String addRole(@RequestParam(name = "userId") String uid,@RequestParam(name = "ids") String[] rids){
        userInfoService.addRole(uid,rids);
        return "redirect:findAll.do";
    }

}

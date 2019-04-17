package com.yzpjy.controller;

import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Permission;
import com.yzpjy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissions);
        mv.addObject("permissionList",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}

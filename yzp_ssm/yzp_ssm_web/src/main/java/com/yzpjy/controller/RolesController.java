package com.yzpjy.controller;

import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Permission;
import com.yzpjy.domain.Role;
import com.yzpjy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RolesController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = false)String  page,
                                @RequestParam(name = "size",defaultValue = "5",required = false) String  size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(roles);
        mv.addObject("rolesList",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 该角色的详情
     * @param rid
     * @return
     */
    @RequestMapping("/findOne.do")
    public ModelAndView findOne(@RequestParam(name = "id") String rid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findOne(rid);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 查找角色还没加的权限
     * @return
     */
    @RequestMapping("/unfind.do")
    public ModelAndView unfind(String rid) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = roleService.unfind(rid);
        Role role = roleService.findOne(rid);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermission.do")
    public String addPermission(@RequestParam(name = "roleId") String rid,@RequestParam(name = "ids") String[] pids){
        roleService.addPermission(rid,pids);
        return "redirect:findAll.do";
    }


}

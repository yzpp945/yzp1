package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.RolesDao;
import com.yzpjy.domain.Permission;
import com.yzpjy.domain.Role;
import com.yzpjy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RolesDao rolesDao;

    public List<Role> findAll(String page, String size) throws Exception {
        int p = Integer.parseInt(page);
        int s = Integer.parseInt(size);
        PageHelper.startPage(p,s);
        return rolesDao.findAll();
    }

    public Role findOne(String rid) throws Exception{
        return rolesDao.findOne(rid);
    }


    public void save(Role role) {
        rolesDao.save(role);
    }

    public List<Permission> unfind(String rid) {
        return rolesDao.unfind(rid);
    }

    public void addPermission(String rid, String[] pids) {
        for (String pid : pids) {
            rolesDao.addPermission(rid,pid);
        }
    }
}

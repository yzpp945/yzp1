package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.PermissionDao;
import com.yzpjy.domain.Permission;
import com.yzpjy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}

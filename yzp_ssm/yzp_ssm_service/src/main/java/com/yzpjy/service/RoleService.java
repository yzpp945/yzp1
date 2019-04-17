package com.yzpjy.service;

import com.yzpjy.domain.Permission;
import com.yzpjy.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll(String page, String size) throws Exception;

    Role findOne(String rid) throws Exception;

    void save(Role role);

    List<Permission> unfind(String rid);

    void addPermission(String rid, String[] pids);
}

package com.yzpjy.service;

import com.yzpjy.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission);
}

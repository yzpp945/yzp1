package com.yzpjy.service;

import com.yzpjy.domain.Role;
import com.yzpjy.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService extends UserDetailsService{

    public List<UserInfo> findAll(int page, int size) throws Exception;

    public UserInfo findOne(String id) throws Exception;

    public void save(UserInfo user) throws Exception;

    public List<Role> unfind(String id) throws Exception;

    void addRole(String uid, String[] rid);
}

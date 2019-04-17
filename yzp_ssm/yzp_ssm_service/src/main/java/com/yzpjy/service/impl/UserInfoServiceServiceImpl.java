package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.UserInfoDao;
import com.yzpjy.domain.Role;
import com.yzpjy.domain.UserInfo;
import com.yzpjy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限 要封装users表权限有一个User类
 */
@Service("userService")
public class UserInfoServiceServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUser_byUsername(username);
        User user = new User(username,"{noop}"+userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,true,true,true,
                getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            System.out.println(authorities);
        }
        return authorities;
    }

    /**
     * 查看全部用户
     * @return
     * @param page
     * @param size
     */
    public List<UserInfo> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);
        return userInfoDao.findAll();
    }

    /**
     * 用户详情
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findOne(String id) throws Exception {
        return userInfoDao.findOne(id);
    }

    public void save(UserInfo user) throws Exception {
        userInfoDao.save(user);
    }

    public List<Role> unfind(String id) throws Exception {
        return userInfoDao.unfind(id);
    }

    public void addRole(String uid, String[] rids) {
        for (String rid : rids) {

        userInfoDao.addRole(uid,rid);
        }
    }
}

package com.yzpjy.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 权限类  与角色表是 多对多的关系 一个角色可以有多个权限 一个权限也可以给多个角色
 */
public class Permission implements Serializable{
    private String id;
    private String permissionName; //权限名
    private String url; //权限可以访问哪些url 也就是可以去哪些页面 看到什么信息
    private List<Role> roles; //角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

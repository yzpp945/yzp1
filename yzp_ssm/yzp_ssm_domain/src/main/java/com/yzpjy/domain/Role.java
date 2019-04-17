package com.yzpjy.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 角色 与 用户 多对多关系 与 权限也是 多 对 多
 */
public class Role implements Serializable{
    private String id;
    private String roleName; //角色名
    private String roleDesc; //角色信息描述
    private List<Permission> permissions; //权限
    private List<UserInfo> users; //用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}

package com.yzpjy.dao;

import com.yzpjy.domain.Permission;
import com.yzpjy.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolesDao {
    /**
     * 如果只是登录 那么 只要是个角色就OK 如果他要增删改就需要权限了
     * @param uid
     * @return
     */
    @Select("select * from role where id in (select roleid from users_role where userid = #{uid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.yzpjy.dao.PermissionDao.findpermission_byRid"))
    })
    public List<Role> findroles_byUid(String uid);

    /**
     * 查询所有的
     * @param uid
     * @return
     */
    @Select("select * from role where id = #{uid}")
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "roleName" ,column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(property = "permissions" ,column = "id" ,many = @Many(select = "com.yzpjy.dao.PermissionDao.findpermission_byRid"))
    })
    public List<Permission> findpermission_byRid(String uid);

    @Select("select * from role")
    public List<Role> findAll();

    @Select("select * from role where id = #{rid}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.yzpjy.dao.PermissionDao.findpermission_byRid")),
            @Result(property = "users",column = "id",many = @Many(select = "com.yzpjy.dao.UserInfoDao.findusers_byRid"))
    })
    Role findOne(String rid);

    @Insert("insert into role (rolename,roledesc) values(#{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("select * from permission where id not in (select permissionid from role_permission where roleid = #{rid})")
    List<Permission> unfind(String rid);

    @Insert("insert into role_permission (permissionId,roleid) values(#{pid},#{rid})")
    void addPermission(@Param("rid") String rid, @Param("pid") String pid);
}

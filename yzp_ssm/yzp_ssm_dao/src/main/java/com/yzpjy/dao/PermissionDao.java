package com.yzpjy.dao;

import com.yzpjy.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select permissionName,url from permission where id in (select permissionId from role_permission where roleid = #{rid})")
    public List<Permission> findpermission_byRid(String rid) throws Exception;

    @Select("select * from permission where id in (select permissionId from permission where roleid = #{id})")
    public List<Permission> findPermission();

    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);

}

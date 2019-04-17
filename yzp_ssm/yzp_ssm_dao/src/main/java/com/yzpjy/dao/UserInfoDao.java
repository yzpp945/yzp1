package com.yzpjy.dao;

import com.yzpjy.domain.Product;
import com.yzpjy.domain.Role;
import com.yzpjy.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum" , column = "phoneNum"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.yzpjy.dao.RolesDao.findroles_byUid"))
    })
    public UserInfo findUser_byUsername(String username);

    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.yzpjy.dao.RolesDao.findroles_byUid"))
    })
    public UserInfo findOne(String id) throws Exception;

    @Insert("insert into users (email,username,PASSWORD,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo user);

    @Select("select * from users where id in (select userid from users_role where roleid = #{rid})")
    public List<UserInfo> findusers_byRid(String rid);

    @Select("select * from role where id not in (select roleid from users_role where userid = #{id})")
    List<Role> unfind(String id);

    @Insert("insert into users_role (userId,roleId) values (#{uid},#{rid}) ")
    void addRole(@Param("uid") String uid,@Param("rid") String rid);
}

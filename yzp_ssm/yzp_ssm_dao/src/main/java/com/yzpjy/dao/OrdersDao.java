package com.yzpjy.dao;

import com.yzpjy.domain.Orders;
import com.yzpjy.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId", one = @One(select = "com.yzpjy.dao.ProductDao.findOne"))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId", one = @One(select = "com.yzpjy.dao.ProductDao.findOne")),
            @Result(property = "member",column = "memberId" , one = @One(select = "com.yzpjy.dao.MemberDao.findOne_byOid")),
            @Result(property = "travellers" ,column = "id" ,many = @Many(select = "com.yzpjy.dao.TravellerDao.findAll_byOid"))
    })
    public Orders findOne(String id) throws  Exception;
}

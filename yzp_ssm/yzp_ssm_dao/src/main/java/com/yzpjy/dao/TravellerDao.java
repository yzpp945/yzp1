package com.yzpjy.dao;

import com.yzpjy.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerDao {
    /**
     * 通过订单（orders）的id 来查找所有游客的信息,关系表in
     * @param id
     * @return
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    public List<Traveller> findAll_byOid(String id) throws Exception;
}

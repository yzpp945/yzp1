package com.yzpjy.dao;

import com.yzpjy.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
    /**
     * 通过订单id 查找会员信息
     * @param id
     * @return
     */
    @Select("select * from member where id = #{#memberId}")
    public Member findOne_byOid(String id) throws Exception;
}

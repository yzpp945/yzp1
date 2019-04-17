package com.yzpjy.service.impl;

import com.yzpjy.dao.MemberDao;
import com.yzpjy.domain.Member;
import com.yzpjy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDao memberDao;
    public Member findOne_byOid(String id) throws Exception {
        return memberDao.findOne_byOid(id);
    }
}

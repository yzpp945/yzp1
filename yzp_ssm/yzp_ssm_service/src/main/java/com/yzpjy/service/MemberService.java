package com.yzpjy.service;


import com.yzpjy.domain.Member;

public interface MemberService {
    public Member findOne_byOid(String id) throws Exception;
}

package com.yzpjy.dao;

import com.yzpjy.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyslogDao {
    @Select("select * from sysLog")
    public List<Syslog> findAll();

    @Insert("insert into sysLog (visitTime,username,ip,url,executionTime,method) values " +
            "(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method}) ")
    public void insertSyslog(Syslog syslog);
}

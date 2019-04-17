package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.SyslogDao;
import com.yzpjy.domain.Syslog;
import com.yzpjy.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class  SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;

    public List<Syslog> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return syslogDao.findAll();
    }

    public void insertSyslog(Syslog syslog) {
        syslogDao.insertSyslog(syslog);
    }
}

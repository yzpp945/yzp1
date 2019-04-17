package com.yzpjy.service;

import com.yzpjy.domain.Syslog;

import java.util.List;

public interface SyslogService {

    public List<Syslog> findAll(Integer page, Integer size);

    public void insertSyslog(Syslog syslog);
}

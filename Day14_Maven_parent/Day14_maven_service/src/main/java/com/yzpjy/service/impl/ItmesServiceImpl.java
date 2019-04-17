package com.yzpjy.service.impl;

import com.yzpjy.dao.ItmesDao;
import com.yzpjy.domain.Itmes;
import com.yzpjy.service.ItmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItmesServiceImpl implements ItmesService {

    @Autowired
    private ItmesDao dao;

    public Itmes findbyid(Integer id){
        return dao.findbyid(id);
    }
}

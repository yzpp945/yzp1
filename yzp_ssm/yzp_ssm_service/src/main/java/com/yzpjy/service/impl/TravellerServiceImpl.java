package com.yzpjy.service.impl;

import com.yzpjy.dao.TravellerDao;
import com.yzpjy.domain.Traveller;
import com.yzpjy.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TravellerServiceImpl implements TravellerService {
    @Autowired
    private TravellerDao travellerDao;
    public List<Traveller> findAll_byOid(String id) throws Exception {
        return travellerDao.findAll_byOid(id);
    }
}

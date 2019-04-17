package com.yzpjy.service;

import com.yzpjy.domain.Traveller;

import java.util.List;

public interface TravellerService {
    public List<Traveller> findAll_byOid(String id) throws Exception;
}

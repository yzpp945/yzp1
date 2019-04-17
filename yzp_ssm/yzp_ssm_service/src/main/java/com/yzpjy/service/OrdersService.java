package com.yzpjy.service;

import com.yzpjy.domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll(String page, String size) throws Exception;

    /**
     * 查询一个订单的所有详细信息
     * @param id
     * @return
     * @throws Exception
     */
    public Orders findOne(String id) throws Exception;
}

package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.OrdersDao;
import com.yzpjy.domain.Orders;
import com.yzpjy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public List<Orders> findAll(String page, String size) throws Exception{
        int p = Integer.parseInt(page);
        int s = Integer.parseInt(size);
        PageHelper.startPage(p,s);
        return ordersDao.findAll();
    }

    public Orders findOne(String id) throws Exception {
        return ordersDao.findOne(id);
    }
}

package com.yzpjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Orders;
import com.yzpjy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")String page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")String size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page,size);
        System.out.println(orders);
        PageInfo pageInfo = new PageInfo(orders);
        System.out.println(pageInfo);
        mv.addObject("ordersList",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 传过来一个订单的id,通过id去跟订单关联的product信息,和会员与用户信息
     * @param id
     */
    @RequestMapping("/findOne.do")
    public ModelAndView findOne(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = ordersService.findOne(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}

package com.yzpjy.controller;

import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Product;
import com.yzpjy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") String page,
                                @RequestParam(name = "size",defaultValue = "5") String size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> products = service.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 保存完后在查询一次
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveProduct.do")
    public String save() throws Exception{
        ModelAndView mv = new ModelAndView();
        service.saveProduct();
        return "redirect:product-list";
    }

}

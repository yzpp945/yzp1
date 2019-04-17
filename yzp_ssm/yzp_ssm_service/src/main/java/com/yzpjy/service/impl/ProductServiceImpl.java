package com.yzpjy.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzpjy.dao.ProductDao;
import com.yzpjy.domain.Product;
import com.yzpjy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao dao;

    public Product findOne(String id) throws Exception {
        return dao.findOne(id);
    }

    public List<Product> findAll(String page, String size) throws Exception{
        int p = Integer.parseInt(page);
        int s = Integer.parseInt(size);
        PageHelper.startPage(p,s);
        return dao.findAll();
    }

    public void saveProduct() throws Exception {
         dao.saveProduct();
    }
}

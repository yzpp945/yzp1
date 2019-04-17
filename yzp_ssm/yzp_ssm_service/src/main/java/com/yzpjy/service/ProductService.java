package com.yzpjy.service;

import com.yzpjy.domain.Product;

import java.util.List;

public interface ProductService {
    public Product findOne(String id) throws Exception;

    public List<Product> findAll(String page, String size) throws Exception;

    public void saveProduct() throws Exception;
}

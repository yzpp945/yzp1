package com.yzpjy.dao;

import com.yzpjy.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ProductDao {

    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into PRODUCT ( productnum, productname, cityname, departuretime, productprice, productdesc, productstatus) values(?,?,?,?,?,?,?)")
    public void saveProduct();

    @Select("select * from product where id = #{id}")
    public Product findOne(String id);
}

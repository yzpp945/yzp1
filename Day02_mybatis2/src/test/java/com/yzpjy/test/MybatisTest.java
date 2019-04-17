package com.yzpjy.test;

import com.yzpjy.dao.UserDao;
import com.yzpjy.dao.impl.UserDaoImpl;
import com.yzpjy.domain.QueryVo;
import com.yzpjy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
        private static InputStream in;

        private static UserDao dao;

        @Before
        public void init() throws Exception {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            dao = new UserDaoImpl(factory);

        }
    //查询
    @Test
    public void findAll() {
            User u = new User();
            u.setUsername("老王");

        List<User> users = dao.findAll(u);
        System.out.println("users:"+users);
        for (User user : users) {
            System.out.println(user);
        }

    }
   /* //更新
    @Test
    public void updateUser(){
            User user = new User();
            user.setUsername("李翠花");
            user.setId(49);
            userDao.updateUser(user);
    }
    //保存
    @Test
    public void save(){
          User user = new User();
        user.setAddress("长沙岳麓区");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setUsername("李嬷嬷");
        System.out.println("保存前"+user);
        userDao.save(user);
        System.out.println("保存后"+user);
    }
    //删除
    @Test
    public void deleteUser(){
         userDao.deleteUser(50);
    }

    //找一个
    @Test
    public void findOne(){
        User user = userDao.findOne(48);
        System.out.println(user);
    }

    //模糊查询
    @Test
    public void likeFind(){
        List<User> users = userDao.likeFind("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    //查询总数
    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println("total:"+total);
    }

    //模糊查询通过QueryVo
    @Test
    public void likeFindByQueryVo(){
            User user = new User();
            user.setUsername("%小%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> users = userDao.likeFindByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @After
    public void destory() throws Exception{
            session.commit();
            session.close();
            in.close();
    }*/
}

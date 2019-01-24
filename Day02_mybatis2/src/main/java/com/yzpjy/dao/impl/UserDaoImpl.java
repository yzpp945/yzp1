package com.yzpjy.dao.impl;

import com.yzpjy.dao.UserDao;
import com.yzpjy.domain.QueryVo;
import com.yzpjy.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll(User user) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.yzpjy.dao.UserDao.findAll",user);
        session.commit();
        session.close();
        return users;
    }

    public void save(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int i) {

    }

    public User findOne(int i) {
        return null;
    }

    public List<User> likeFind(String str) {
        return null;
    }

    public int findTotal() {
        return 0;
    }

    public List<User> likeFindByVo(QueryVo vo) {
        return null;
    }
}

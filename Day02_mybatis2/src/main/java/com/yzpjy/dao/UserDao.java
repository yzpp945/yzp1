package com.yzpjy.dao;

import com.yzpjy.domain.QueryVo;
import com.yzpjy.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
   // @Select("select * from user")
    List<User> findAll(User user);

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param i
     */
    void deleteUser(int i);

    /**
     * 查找一个用户
     * @param i
     * @return
     */
    User findOne(int i);

    /**
     * 模糊查询
     * @param
     * @return
     */
    List<User> likeFind(String str);

    /**
     * 查询总数
     * @return
     */
    int findTotal();

    /**
     * 通过QueryVo对象查询
     * @param vo
     * @return
     */
    List<User> likeFindByVo(QueryVo vo);
}

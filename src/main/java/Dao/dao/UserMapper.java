package Dao.dao;

import Dao.model.User;

public interface UserMapper {
    void deleteByPrimaryKey(Integer userid);

    void insert(User record);

    void insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    String selectByUserName(String userName);

    User selectByEmail(String email);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User record);

    String findPassWord(String userNameOrEmail);

    User selectUserByUserName(String userName);

    int selectUserId(String userNameOrEmail);
}
package Dao.dao;

import Dao.model.UserAuthority;

public interface UserAuthorityMapper {
    void deleteByPrimaryKey(Integer authorityid);

    void insert(UserAuthority record);

    void insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(Integer authorityid);

    void updateByPrimaryKeySelective(UserAuthority record);

    void updateByPrimaryKey(UserAuthority record);
}
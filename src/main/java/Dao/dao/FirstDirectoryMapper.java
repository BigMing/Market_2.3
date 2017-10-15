package Dao.dao;

import Dao.model.FirstDirectory;

public interface FirstDirectoryMapper {
    void deleteByPrimaryKey(Integer fdid);

    void insert(FirstDirectory record);

    void insertSelective(FirstDirectory record);

    FirstDirectory selectByPrimaryKey(Integer fdid);

    void updateByPrimaryKeySelective(FirstDirectory record);

    void updateByPrimaryKey(FirstDirectory record);
}
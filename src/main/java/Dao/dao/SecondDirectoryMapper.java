package Dao.dao;

import Dao.model.SecondDirectory;

public interface SecondDirectoryMapper {
    void deleteByPrimaryKey(Integer sdid);

    void insert(SecondDirectory record);

    void insertSelective(SecondDirectory record);

    SecondDirectory selectByPrimaryKey(Integer sdid);

    void updateByPrimaryKeySelective(SecondDirectory record);

    void updateByPrimaryKey(SecondDirectory record);
}
package Dao.dao;

import Dao.model.SendEmail;

public interface SendEmailMapper {
    int deleteByPrimaryKey(Integer sendemailid);

    int insert(SendEmail record);

    int insertSelective(SendEmail record);

    SendEmail selectByPrimaryKey(Integer sendemailid);

    int updateByPrimaryKeySelective(SendEmail record);

    int updateByPrimaryKey(SendEmail record);

    SendEmail selectByEmail(String email);

    SendEmail selectByRandomNumber(String RandomNumber);

    SendEmail selectByUserId(int userId);
}
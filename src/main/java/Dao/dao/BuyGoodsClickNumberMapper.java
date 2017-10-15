package Dao.dao;

import Dao.model.BuyGoodsClickNumber;

public interface BuyGoodsClickNumberMapper {
    void deleteByPrimaryKey(Integer bgclicknumberid);

    void insert(BuyGoodsClickNumber record);

    void insertSelective(BuyGoodsClickNumber record);

    BuyGoodsClickNumber selectByPrimaryKey(Integer bgclicknumberid);

    void updateByPrimaryKeySelective(BuyGoodsClickNumber record);

    void updateByPrimaryKey(BuyGoodsClickNumber record);
}
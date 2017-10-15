package Dao.dao;

import Dao.model.BuyGoods;

import java.util.List;

public interface BuyGoodsMapper {
    void deleteByPrimaryKey(Integer buygoodsid);

    void insert(BuyGoods record);

    void insertSelective(BuyGoods record);

    BuyGoods selectByPrimaryKey(Integer buygoodsid);

    void updateByPrimaryKeySelective(BuyGoods record);

    void updateByPrimaryKey(BuyGoods record);

    List<BuyGoods> selectByUserId(int userId);
}
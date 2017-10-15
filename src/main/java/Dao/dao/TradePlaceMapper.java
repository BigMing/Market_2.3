package Dao.dao;

import Dao.model.TradePlace;

public interface TradePlaceMapper {
    void deleteByPrimaryKey(Integer tradeplaceid);

    void insert(TradePlace record);

    void insertSelective(TradePlace record);

    TradePlace selectByPrimaryKey(Integer tradeplaceid);

    void updateByPrimaryKeySelective(TradePlace record);

    void updateByPrimaryKey(TradePlace record);
}
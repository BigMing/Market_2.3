package Dao.dao;

import Dao.model.SaleGoods;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SaleGoodsMapper {
    void deleteByPrimaryKey(Integer salegoodsid);

    void insert(SaleGoods record);

    void insertSelective(SaleGoods record);

    SaleGoods selectByPrimaryKey(Integer salegoodsid);

    void updateByPrimaryKeySelective(SaleGoods record);

    void updateByPrimaryKey(SaleGoods record);

    List<SaleGoods> selectByHeadline(String searchWords);

    List<SaleGoods> selectBySecondDirectoryId(int secondDirectoryId);

    List<SaleGoods> selectByUserId(int userId);

    List<SaleGoods> selectAll();

    int selectSaleGoodsId(Map<String,Object> map);
}
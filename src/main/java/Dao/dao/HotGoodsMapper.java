package Dao.dao;

import Dao.model.HotGoods;

import java.util.List;

public interface HotGoodsMapper {
    int deleteByPrimaryKey(Integer hotgoodsid);

    int insert(HotGoods record);

    int insertSelective(HotGoods record);

    HotGoods selectByPrimaryKey(Integer hotgoodsid);

    int updateByPrimaryKeySelective(HotGoods record);

    int updateByPrimaryKey(HotGoods record);

    HotGoods selectBySaleGoodsId(int SaleGoodsId);

    void deleteAll();

    List<HotGoods> selectAll();
}
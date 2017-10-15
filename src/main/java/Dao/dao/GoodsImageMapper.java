package Dao.dao;

import Dao.model.GoodsImage;

import java.util.List;

public interface GoodsImageMapper {
    void deleteByPrimaryKey(Integer giid);

    void insert(GoodsImage record);

    void insertSelective(GoodsImage record);

    GoodsImage selectByPrimaryKey(Integer giid);

    void updateByPrimaryKeySelective(GoodsImage record);

    void updateByPrimaryKey(GoodsImage record);

    List<String> selectByGoodsId(Integer saleGoodsId);
}
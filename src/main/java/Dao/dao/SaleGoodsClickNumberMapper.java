package Dao.dao;

import Dao.model.SaleGoodsClickNumber;

import java.util.List;

public interface SaleGoodsClickNumberMapper {
    void deleteByPrimaryKey(Integer sgclicknumberid);

    void insert(SaleGoodsClickNumber record);

    void insertSelective(SaleGoodsClickNumber record);

    SaleGoodsClickNumber selectByPrimaryKey(Integer sgclicknumberid);

    void updateByPrimaryKeySelective(SaleGoodsClickNumber record);

    void updateByPrimaryKey(SaleGoodsClickNumber record);

    SaleGoodsClickNumber selectBySaleGoodsId(int saleGoodsId);

    List<SaleGoodsClickNumber> selectAll();
}
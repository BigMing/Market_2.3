package Dao.dao;

import Dao.model.CollectGoods;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CollectGoodsMapper {
    void deleteByPrimaryKey(Integer cgid);

    void insert(CollectGoods record);

    void insertSelective(CollectGoods record);

    CollectGoods selectByPrimaryKey(Integer cgid);

    void updateByPrimaryKeySelective(CollectGoods record);

    List<Integer> selectGoodsIdByUserId(Integer userId);

    void updateByPrimaryKey(CollectGoods record);

    CollectGoods selectcGIdByUserIdAndGoodsId(Map<String,Object> map);

    void delete(CollectGoods collectGoods);
}
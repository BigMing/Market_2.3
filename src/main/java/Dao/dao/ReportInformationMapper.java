package Dao.dao;

import Dao.model.ReportInformation;

import java.util.List;
import java.util.Map;

public interface ReportInformationMapper {
    int deleteByPrimaryKey(Integer informationid);

    int insert(ReportInformation record);

    int insertSelective(ReportInformation record);

    ReportInformation selectByPrimaryKey(Integer informationid);

    int updateByPrimaryKeySelective(ReportInformation record);

    int updateByPrimaryKey(ReportInformation record);

    List<Integer> selectSaleGoodsGroup();

    Map<Integer,Integer> selectSaleGoodsGroupMap();
}
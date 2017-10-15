package Service;

import Dao.dao.SaleGoodsMapper;
import Dao.dao.SecondDirectoryMapper;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2014/9/3.
 */

@Service
public class DirectoryService {
    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(DirectoryService.class);

    public List<SaleGoods> showGoodsList(int secondDirectoryId){
        try{
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectBySecondDirectoryId(secondDirectoryId);
            return saleGoodsList;
        }
        catch (Exception ex) {
            logger.error("exception in DirectoryService", ex);
            return null;
            //return 0;
        }
    }

    public List<SaleGoods> showGoodsOrderByHotRate(int sDId){
        try {
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectBySecondDirectoryId(sDId);
            return orderGoodsService.orderByHotRate(saleGoodsList);
        }
        catch (Exception ex){
            logger.error("exception in  DirectoryService.orderByHotRate",ex);
            return null;
        }
    }

    public List<SaleGoods> showGoodsOrderByPostTime(int sDId){
        try {
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectBySecondDirectoryId(sDId);
            return orderGoodsService.orderByPostTime(saleGoodsList);
        }
        catch (Exception ex){
            logger.error("exception in  DirectoryService.orderByHotRate",ex);
            return null;
        }
    }

    public List<SaleGoods> showGoodsOrderByPrice(int sDId){
        try {
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectBySecondDirectoryId(sDId);
            return orderGoodsService.orderByPrice(saleGoodsList);
        }
        catch (Exception ex){
            logger.error("exception in  DirectoryService.orderByHotRate",ex);
            return null;
        }
    }
}

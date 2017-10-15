package Service;

import Dao.dao.SaleGoodsMapper;
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
public class SearchService {
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired
    private OrderGoodsService orderGoodsService;

    private static Logger logger = LoggerFactory.getLogger(SearchService.class);

    public List<SaleGoods> searchGoods(String searchWords){
        try{
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectByHeadline(searchWords);
            return saleGoodsList;
        }
        catch (Exception ex) {
            logger.error("exception in SearchService", ex);
            return null;
            //return 0;
        }
    }

    public List<SaleGoods> searchByHotRate(String searchWord){
        try{
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectByHeadline(searchWord);
            return orderGoodsService.orderByHotRate(saleGoodsList);
        }
        catch (Exception ex) {
            logger.error("exception in SearchService", ex);
            return null;
            //return 0;
        }
    }

    public List<SaleGoods> searchByPostTime(String searchWord){
        try{
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectByHeadline(searchWord);
            return orderGoodsService.orderByPostTime(saleGoodsList);
        }
        catch (Exception ex) {
            logger.error("exception in SearchService", ex);
            return null;
            //return 0;
        }
    }

    public List<SaleGoods> searchByPrice(String searchWord){
        try{
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            saleGoodsList = saleGoodsMapper.selectByHeadline(searchWord);
            return orderGoodsService.orderByPrice(saleGoodsList);
        }
        catch (Exception ex) {
            logger.error("exception in SearchService", ex);
            return null;
            //return 0;
        }
    }
}

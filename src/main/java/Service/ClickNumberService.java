package Service;

import Dao.dao.BuyGoodsClickNumberMapper;
import Dao.dao.SaleGoodsClickNumberMapper;
import Dao.model.BuyGoodsClickNumber;
import Dao.model.ReportInformation;
import Dao.model.SaleGoodsClickNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/9/12 0012.
 */
@Service
public class ClickNumberService {
    @Autowired(required = false)
    private SaleGoodsClickNumberMapper saleGoodsClickNumberMapper;
    @Autowired(required = false)
    private BuyGoodsClickNumberMapper buyGoodsClickNumberMapper;

    private static Logger logger = LoggerFactory.getLogger(ClickNumberService.class);

    public void addGoodsClickNumber(int saleGoodsId){
        SaleGoodsClickNumber saleGoodsClickNumber = saleGoodsClickNumberMapper.selectBySaleGoodsId(saleGoodsId);
        if (saleGoodsClickNumber == null){
            SaleGoodsClickNumber clickNumber = new SaleGoodsClickNumber();
            clickNumber.setSalegoodsid(saleGoodsId);
            clickNumber.setSgclicknumber(1);
            saleGoodsClickNumberMapper.insert(clickNumber);
        }
        else {
            int temp = saleGoodsClickNumber.getSgclicknumber();
            saleGoodsClickNumber.setSgclicknumber(temp + 1);
            saleGoodsClickNumberMapper.updateByPrimaryKeySelective(saleGoodsClickNumber);
        }
    }

    public void addBuyClickNumber(int buyGoodsId){
        BuyGoodsClickNumber buyGoodsClickNumber = buyGoodsClickNumberMapper.selectByPrimaryKey(buyGoodsId);
        if (buyGoodsClickNumber == null){
            BuyGoodsClickNumber clickNumber = new BuyGoodsClickNumber();
            clickNumber.setBuygoodsid(buyGoodsId);
            clickNumber.setBgclicknumber(1);
            buyGoodsClickNumberMapper.insert(clickNumber);
        }
        else {
            int temp = buyGoodsClickNumber.getBgclicknumber();
            buyGoodsClickNumber.setBgclicknumber(temp + 1);
            buyGoodsClickNumberMapper.updateByPrimaryKeySelective(buyGoodsClickNumber);
        }
    }
}

package Controller;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Service.ClickNumberService;
import Service.GoodsImagesService;
import Service.ShowSaleGoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by li on 2014/9/15.
 */
@Controller
public class ShowGoodsDetailControlller {
    @Autowired
    private  ShowSaleGoodsDetailService showSaleGoodsDetailService;
    @Autowired
    private ClickNumberService clickNumberService;
    @Autowired
    private GoodsImagesService goodsImagesService;

    @RequestMapping(value = "/goodsDetail/saleGoods/{saleGoodsId}",method= RequestMethod.GET)
    public @ResponseBody SaleGoods getSaleGoods(@PathVariable int saleGoodsId){
        System.out.println(saleGoodsId);
        SaleGoods saleGoods = showSaleGoodsDetailService.getSaleGoods(saleGoodsId);
        System.out.println(saleGoods.getHeadline());
        clickNumberService.addGoodsClickNumber(saleGoodsId);
        return  saleGoods;
    }

    @RequestMapping(value="/goodsImage/saleGoods/{saleGoodsId}",method = RequestMethod.GET)
    public @ResponseBody
    List<String> goodsImage(@PathVariable int saleGoodsId){
       List<String> goodsImageList = goodsImagesService.findImageBySaleGoodsId(saleGoodsId);
       return  goodsImageList;
    }

    @RequestMapping(value = "/goodsDetail/buyGoods/{buyGoodsId}",method= RequestMethod.GET)
    public  @ResponseBody
    BuyGoods getBuyGoods(@PathVariable int buyGoodsId){
        BuyGoods buyGoods = showSaleGoodsDetailService.getBuyGoods(buyGoodsId);
        clickNumberService.addBuyClickNumber(buyGoodsId);
        return  buyGoods;
    }
}

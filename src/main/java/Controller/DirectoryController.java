package Controller;

import Dao.model.SaleGoods;
import Service.DirectoryService;
import Service.GoodsImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by li on 2014/9/9.
 */
@Controller
public class DirectoryController {
    @Autowired
    DirectoryService directoryService;
    @Autowired
    GoodsImagesService goodsImagesService;

    @RequestMapping(value = "/directory/{sDId}",method = RequestMethod.GET)
    public @ResponseBody List<SaleGoods>
    getGoodsByDirectory(@PathVariable("sDId") int sDId){
        //System.out.println(sDId);
        List <SaleGoods> saleGoodsList = directoryService.showGoodsList(sDId);
        //System.out.println(saleGoodsList.size());

        //System.out.println(saleGoodsList.get(0).getContactor());
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }

        //System.out.println(saleGoodsList.get(0).getGoodsImage());
        //modelMap.addAttribute("saleGoodsList",saleGoodsList);
        return  saleGoodsList;
    }

    @ResponseBody
    @RequestMapping(value = "/directory/orderByHotRate/{sDId}",method = RequestMethod.GET)
    public List<SaleGoods> getOrderedByHotRate(@PathVariable int sDId){
        List<SaleGoods> saleGoodsList = directoryService.showGoodsOrderByHotRate(sDId);
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }
        return saleGoodsList;
    }

    @ResponseBody
    @RequestMapping(value = "/directory/orderByPostTime/{sDId}",method = RequestMethod.GET)
    public List<SaleGoods> getOrderedByPostTime(@PathVariable int sDId){
        List<SaleGoods> saleGoodsList = directoryService.showGoodsOrderByPostTime(sDId);
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }
        return saleGoodsList;
    }

    @ResponseBody
    @RequestMapping(value = "/directory/orderByPrice/{sDId}",method = RequestMethod.GET)
    public List<SaleGoods> getOrderedByPrice(@PathVariable int sDId){
        List<SaleGoods> saleGoodsList = directoryService.showGoodsOrderByPrice(sDId);
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }
        return saleGoodsList;
    }
}

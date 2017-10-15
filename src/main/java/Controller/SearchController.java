package Controller;

import Dao.model.SaleGoods;
import Service.GoodsImagesService;
import Service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */

@Controller
@RequestMapping("/saleGoods")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private GoodsImagesService goodsImagesService;

    private static Logger logger = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping(value = "/{searchWord}", method = RequestMethod.GET)
    @ResponseBody
    public List<SaleGoods> search(@PathVariable String searchWord) {
        //System.out.println(searchWord);
        //List<String> headLines = new ArrayList<String>();
        List<SaleGoods> saleGoodsList = searchService.searchGoods("%" + searchWord + "%");
        System.out.println(saleGoodsList.size());
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }
        return saleGoodsList;
    }

    @ResponseBody
    @RequestMapping(value = "/orderByHotRate/{searchWord}",method = RequestMethod.GET)
    public List<SaleGoods> searchByHotRate(@PathVariable String searchWord){
        return searchService.searchByHotRate(searchWord);
    }

    @ResponseBody
    @RequestMapping(value = "/orderByPostTime/{searchWord}",method = RequestMethod.GET)
    public List<SaleGoods> searchByPostTime(@PathVariable String searchWord){
        return searchService.searchByPostTime(searchWord);
    }

    @ResponseBody
    @RequestMapping(value = "/orderByPrice/{searchWord}",method = RequestMethod.GET)
    public List<SaleGoods> searchByPrice(@PathVariable String searchWord){
        return searchService.searchByPrice(searchWord);
    }
}

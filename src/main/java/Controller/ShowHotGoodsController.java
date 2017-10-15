package Controller;

import Dao.model.HotGoods;
import Service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class ShowHotGoodsController {
    @Autowired
    private HotGoodsService hotGoodsService;

    private static Logger logger = LoggerFactory.getLogger(ShowHotGoodsController.class);

    @ResponseBody
    @RequestMapping(value = "/hotGoods",method = RequestMethod.GET)
    public List<HotGoods> getHotGoods(){
        return hotGoodsService.showGotHoods();
    }
}

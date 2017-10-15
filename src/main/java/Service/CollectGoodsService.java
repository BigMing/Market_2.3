package Service;

import Dao.dao.CollectGoodsMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.dao.UserMapper;
import Dao.model.CollectGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 2014/9/4.
 */
@Service
public class CollectGoodsService {

    @Autowired(required = false)
    private CollectGoodsMapper collectGoodsMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired
    private CommentService commentService;

    private static Logger logger = LoggerFactory.getLogger(CollectGoodsService.class);

    private List<Integer> goodsIdList = new ArrayList<Integer>();

    public String saveCollectGoods(int goodsId, int userId) {
        try {
            if (judgeCollectGoods(goodsId, userId)){
                CollectGoods collectGoods = new CollectGoods();
                collectGoods.setUserid(userId);
                collectGoods.setSalegoodsid(goodsId);
                //message to who publish goods
                User user = userMapper.selectByPrimaryKey(userId);
                SaleGoods saleGoods = saleGoodsMapper.selectByPrimaryKey(goodsId);
                String text = "您发布的商品：" + saleGoods.getHeadline() +
                        " 被用户：" + user.getUsername() + " 收藏，请查看。";
                commentService.saveComments(text,0,goodsId);
                //insert collection into DB
                collectGoodsMapper.insert(collectGoods);
                return "success collect";
            }
            else
                return "collection exist";
        } catch (Exception ex) {
            logger.error("exception in CollectGoodsService.save", ex);
            return "exception in CollectGoodsService";
            //return 0;
        }
    }

    public boolean judgeCollectGoods(int goodsId, int userId){
        try {
            goodsIdList = collectGoodsMapper.selectGoodsIdByUserId(userId);
            for (int i = 0; i < goodsIdList.size(); i++){
                if (goodsIdList.get(i) == goodsId)
                    return false;
            }
            return true;
        }
        catch (Exception ex) {
            logger.error("exception in CollectGoodsService.judge", ex);
            //return "exception in CollectGoodsService";
            return false;
        }
    }

    public List<SaleGoods> showCollection(int userId){
        try {
            goodsIdList = collectGoodsMapper.selectGoodsIdByUserId(userId);
            //System.out.println(goodsIdList);
            List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
            for (int i = 0;i < goodsIdList.size();i++){
                saleGoodsList.add(saleGoodsMapper.selectByPrimaryKey(goodsIdList.get(i)));
            }
            return saleGoodsList;
        }
        catch (Exception ex) {
            logger.error("exception in CollectGoodsService.showCollection", ex);
            //return "exception in CollectGoodsService.showCollection";
            return null;
        }
    }

    public String deleteCollection(int userId, int goodsId){
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("userId",userId);
            map.put("goodsId",goodsId);
            CollectGoods collectGoods = collectGoodsMapper.selectcGIdByUserIdAndGoodsId(map);
            collectGoodsMapper.delete(collectGoods);
            return "delete success";
        }
        catch (Exception ex) {
            logger.error("exception in CollectGoodsService.deleteCollection", ex);
            return "exception in CollectGoodsService.deleteCollection";
            //return false;
        }
    }
}

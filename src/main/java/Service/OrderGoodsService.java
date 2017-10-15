package Service;

import Dao.dao.SaleGoodsClickNumberMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2014/9/16 0016.
 */
@Service
public class OrderGoodsService {
    @Autowired(required = false)
    private SaleGoodsClickNumberMapper saleGoodsClickNumberMapper;
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(OrderGoodsService.class);

    public List<SaleGoods> orderByHotRate(List<SaleGoods> list){
        //int[] clickNumbers = new int[list.size()];
        Map<Integer,Object> map = new TreeMap<Integer, Object>(new Comparator<Integer>() {
            public int compare(Integer obj1, Integer obj2){
                return obj2.compareTo(obj1);
            }
        });
        for (int i = 0; i < list.size(); i++){
            int clickNumber = saleGoodsClickNumberMapper.selectBySaleGoodsId(
                    list.get(i).getSalegoodsid()).getSgclicknumber();
            map.put(clickNumber,list.get(i));
        }
        List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iter = keySet.iterator();
        while (iter.hasNext()){
            int key = iter.next();
            saleGoodsList.add((SaleGoods)map.get(key));
        }
        return saleGoodsList;
    }

    public List<SaleGoods> orderByPostTime(List<SaleGoods> list){
        List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
        long temp2 = new Date().getTime();
        for (int i = 0;i < list.size();i++){
            SaleGoods goods = list.get(i);
            long temp1 = list.get(i).getPosttime().getTime();
            for (int j = i;j < list.size();j++){
                if (list.get(j).getPosttime().getTime() > temp1
                        && list.get(j).getPosttime().getTime() < temp2){
                    temp1 = list.get(j).getPosttime().getTime();
                    goods = list.get(j);
                }
            }
            temp2 = temp1;
            saleGoodsList.add(goods);
        }
        return saleGoodsList;
    }

    public List<SaleGoods> orderByPrice(List<SaleGoods> list){
        List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
        double temp2 = 10000000;
        for (int i = 0;i < list.size();i++){
            SaleGoods goods = list.get(i);
            double temp1 = list.get(i).getPrice();
            for (int j = i; j < list.size();j++){
                if (list.get(j).getPrice() > temp1
                        && list.get(j).getPrice() < temp2){
                    temp1 = list.get(j).getPrice();
                    goods = list.get(j);
                }
            }
            temp2 = temp1;
            saleGoodsList.add(goods);
        }
        return saleGoodsList;
    }
}

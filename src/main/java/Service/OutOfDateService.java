package Service;

import Dao.dao.SaleGoodsMapper;
import Dao.dao.UserMapper;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014/9/12 0012.
 */

@Service
public class OutOfDateService {
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private JavaMailSender mailSender;

    private static Logger logger = LoggerFactory.getLogger(OutOfDateService.class);

    @Scheduled(cron = "0 0 2 * * ?")
    public void checkDeadLine(){
        List<SaleGoods> goodsList = saleGoodsMapper.selectAll();
        Date newDate = new Date();
        for (int i = 0; i < goodsList.size(); i++){
            long temp = newDate.getTime() - goodsList.get(i).getPosttime().getTime();
            temp = temp / 1000;//second
            temp = temp / 3600 / 24;//day
            if (temp > 20){
                SaleGoods saleGoods = goodsList.get(i);
                int userId = saleGoods.getUserid();
                User user = userMapper.selectByPrimaryKey(userId);
                saleGoods.setGoodsflag(2);//out date flag
                saleGoodsMapper.updateByPrimaryKeySelective(saleGoods);
                sendEmail(user.getEmail(), goodsList.get(i));
            }
            if (temp > 16 && temp <= 20){
                SaleGoods saleGoods = goodsList.get(i);
                int userId = saleGoods.getUserid();
                User user = userMapper.selectByPrimaryKey(userId);
                sendEmail_1(user.getEmail(), goodsList.get(i));
            }
        }
    }

    public void sendEmail_1(String email,SaleGoods saleGoods){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bestseuapb@163.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("跳蚤市场-商品到期提醒");
        String text = "您发布的商品：";
        text = text + saleGoods.getHeadline();
        text = text + " 即将过期，请您查看。";
        mailMessage.setText(text);
        mailSender.send(mailMessage);
    }

    public void sendEmail(String email,SaleGoods saleGoods){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bestseuapb@163.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("跳蚤市场-商品到期提醒");
        String text = "您发布的商品：";
        text = text + saleGoods.getHeadline();
        text = text + " 已经过期，请您查看。";
        mailMessage.setText(text);
        mailSender.send(mailMessage);
    }
}

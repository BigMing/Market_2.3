package Service;

import Dao.dao.ReportInformationMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.dao.UserMapper;
import Dao.model.ReportInformation;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class ReportService {
    @Autowired(required = false)
    private ReportInformationMapper reportInformationMapper;
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;

    @Autowired
    private JavaMailSender mailSender;

    private static Logger logger = LoggerFactory.getLogger(ReportService.class);

    public String saveReportInformation(ReportInformation reportInformation){
        try {
            //notice the guy who is been reported
            int goodsId = reportInformation.getSalegoodsid();
            SaleGoods saleGoods = saleGoodsMapper.selectByPrimaryKey(goodsId);
            String text = "您发布的商品：";
            text = text + saleGoods.getHeadline();
            text = text + " 被人举报，请您查看。";
            commentService.saveComments(text,0,goodsId);
            //send email to notice
            sendEmailToUser(saleGoods);
            //save report in DB
            reportInformation.setReporttime(new Date());
            reportInformationMapper.insertSelective(reportInformation);
            return "insert into DB";
        }
        catch (Exception ex) {
            logger.error("exception in ReportInformation", ex);
            System.out.println(ex.getMessage());
            return "exception in ReportInformation";
            //return 0;
        }
    }

    public void sendEmailToUser(SaleGoods saleGoods){
        int userId = saleGoods.getUserid();
        User user = userMapper.selectByPrimaryKey(userId);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bestseuapb@163.com");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("跳蚤市场-被举报商品");
        mailMessage.setText("你发布的商品：" + saleGoods.getHeadline() + " 被举报，请查看。");
        mailSender.send(mailMessage);
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void statistics(){
        try {
            List<Integer> list = reportInformationMapper.selectSaleGoodsGroup();
//            for (int i = 0; i < list.size(); i++){
//                System.out.println(list.get(i));
//            }
            final int size = list.size();
            int[] ids = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = list.get(i);
            }
            Arrays.sort(ids);
//            for (int i = 0; i < size; i++) {
//                System.out.println(ids[i]);
//            }
            int[] goodsIds = new int[size];
            goodsIds[0] = ids[0];
            int[] reportTimes = new int[size];
            reportTimes[0] = 1;
            int count = 0;
            for (int i = 1; i < size; i++){
                if (ids[i] == goodsIds[count]){
                    reportTimes[count]++;
                }
                else {
                    count++;
                    goodsIds[count] = ids[i];
                    reportTimes[count] = 1;
                }
            }
//            for (int i = 0; i <= count; i++){
//                System.out.print(goodsIds[i] + " ");
//                System.out.print(reportTimes[i]+"\n");
//            }
//            Map<Integer,Integer> map = reportInformationMapper.selectSaleGoodsGroupMap();
//            System.out.println(map.get(1));
            for (int i = 0; i < reportTimes.length; i++){
                if (reportTimes[i] > 10){
                    sendEmailToManager(goodsIds[i]);
                }
            }
        }
        catch (Exception ex){
            logger.error("exception in ReportInformation.statistics", ex);
        }
    }

    public void sendEmailToManager(int goodsId){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bestseuapb@163.com");
        mailMessage.setTo("532692737@qq.com");
        mailMessage.setSubject("跳蚤市场-被举报商品");
        mailMessage.setText("被举报商品的id是：" + goodsId);
        //mailMessage.setText("Hello");
        mailSender.send(mailMessage);
    }
}

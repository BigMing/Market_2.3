package Service;

import Dao.dao.SendEmailMapper;
import Dao.dao.UserMapper;
import Dao.model.SendEmail;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2014/9/11 0011.
 */

@Service
public class FindPassWordService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private SendEmailMapper sendEmailMapper;

    public static final String homeUrl = "http://localhost:8080/findPassWord/";

    private static Logger logger = LoggerFactory.getLogger(FindPassWordService.class);

    public User checkEmail(String email){
        try {
            User user = userMapper.selectByEmail(email);
            if (user == null)
                return null;
            else
                return user;
        }
        catch (Exception ex){
            logger.error("exception in FindPassWordService",ex);
            return null;
        }
    }

    public void sendMail(User user){
        String email = user.getEmail();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bestseuapb@163.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("跳蚤市场-找回密码");

        String text = getEmailText(user);
        mailMessage.setText(text);

        //mailMessage.setText("Hello");
        mailSender.send(mailMessage);
    }

    public String getEmailText(User user){
        String randomNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        saveEmailInfo(randomNumber,user);
        String temp = String.valueOf(user.getUserid());
        String url = homeUrl + randomNumber + "?userId=" + temp;
        url = "请点击连接，修改密码：" + url;
        //System.out.println(url);
        return url;
    }

//    public int getUserId(String email){
//        try {
//            //System.out.println(email);
//            return userMapper.selectUserId(email);
//        }
//        catch (Exception ex){
//            logger.error("exception in SendEmailService.getUserId",ex);
//            //System.out.println(ex.getMessage());
//            return 0;
//        }
//    }

    public void saveEmailInfo(String randomNumber, User user){
        String email = user.getEmail();
        SendEmail sendEmail = new SendEmail();
        sendEmail.setEmail(email);
        sendEmail.setRandomnumber(randomNumber);
        sendEmail.setValidflag(false);
        sendEmail.setUserid(user.getUserid());
        sendEmail.setRequesttime(new Date());
        //sendEmail.setRequesttime();
        if (sendEmailMapper.selectByEmail(email) == null){
            sendEmailMapper.insert(sendEmail);
        }
        else {
            SendEmail sendEmail_1 = sendEmailMapper.selectByEmail(email);
            sendEmail_1.setRandomnumber(randomNumber);
            sendEmail_1.setRequesttime(new Date());
            System.out.println(sendEmail_1.getRequesttime());
            sendEmail_1.setValidflag(false);
            sendEmailMapper.updateByPrimaryKeySelective(sendEmail_1);
        }
    }

    public boolean check(String randomNumber, int userId){
        SendEmail sendEmail = sendEmailMapper.selectByUserId(userId);
        Date newDate = new Date();
        Date oldDate = sendEmail.getRequesttime();
        //System.out.println(oldDate);
        long temp = newDate.getTime() - oldDate.getTime();
        temp = temp / 1000;
        //System.out.println(sendEmail.getRandomnumber());
        //System.out.println(sendEmail.getValidflag());
        if (!randomNumber.equals(sendEmail.getRandomnumber())
                || sendEmail.getValidflag() == true
                || temp > 3600 ) {
            return false;
        }
        else {
            SendEmail sendEmail1 = sendEmailMapper.selectByRandomNumber(randomNumber);
            sendEmail1.setValidflag(true);
            sendEmailMapper.updateByPrimaryKeySelective(sendEmail1);
            return true;
        }
    }

//    public void getDate(){
//        SendEmail sendEmail = sendEmailMapper.selectByPrimaryKey(1);
//        System.out.println(sendEmail.getRequesttime());
//    }
}

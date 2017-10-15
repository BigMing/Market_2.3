package Client;

import Dao.model.Comment;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */

@Controller
public class CommentClient {
    private static Logger logger = LoggerFactory.getLogger(CommentClient.class);

    @RequestMapping(value = "/comment/add",method = RequestMethod.POST)
    public String addComment(ModelMap model,
                             @RequestParam String commentText,
                             @RequestParam int commenterId,
                             @RequestParam int goodsId){
        //System.out.println(commentText);
        String result = new RestTemplate().postForObject(
                "http://localhost:8080/comment/{commentText}/{commenterId}/{goodsId}",
                null, String.class,
                commentText, commenterId, goodsId);
        model.addAttribute("message", result);
        return "result";
    }

    @RequestMapping(value = "/comment/delete",method = RequestMethod.POST)
    public String deleteComment(ModelMap model,
                                @RequestParam int commenterId,
                                @RequestParam int goodsId){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/comment/{commenterId}/{saleGoodsId}",
                commenterId, goodsId);
        model.addAttribute("message","delete comment");
        return "result";
    }

    @RequestMapping(value = "/commentShow",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> showCommentByUserId(ModelMap model,HttpSession httpSession){
        if(httpSession.getAttribute("userId") != null){
            int userId = (Integer) httpSession.getAttribute("userId");
            List<Comment> commentList = new RestTemplate().getForObject(
                    "http://localhost:8080/comment/user/{userId}", ArrayList.class, userId);
            System.out.println(commentList.size());
            return commentList;
        }
        else{
            return  null;
        }
        
//        model.addAttribute("commentList",commentList);
//        return "result";
    }
    @RequestMapping(value ="/comment/{saleGoodsId}",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> showCommentBySaleGoodsId(@PathVariable int saleGoodsId,ModelMap modelMap){
        //System.out.println(saleGoodsId);
        List<Comment> commentList = new RestTemplate().getForObject(
                "http://localhost:8080/comment/saleGoodsId/{saleGoodsId}",ArrayList.class,saleGoodsId);
        System.out.println(commentList.size());
//        modelMap.addAttribute("commentList",commentList);
//        return  "result";
        return commentList;
    }
}

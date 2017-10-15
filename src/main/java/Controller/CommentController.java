package Controller;

import Dao.model.Comment;
import Service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @ResponseBody
    @RequestMapping(value = "/{commentText}/{commenterId}/{goodsId}",method = RequestMethod.POST)
    public String addComment(@PathVariable String commentText,
                             @PathVariable int commenterId,
                             @PathVariable int goodsId){
        //System.out.println(commentText);
        commentService.saveComments(commentText,commenterId,goodsId);
        return "save comments";
    }

    @ResponseBody
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public List<Comment> showComment(@PathVariable int userId){
       Comment [] comments = commentService.showComments(userId);
       System.out.println(comments[0].getCommenttext());
       List<Comment> commentList = new ArrayList<Comment>();
        for(int i = 0;i < comments.length; i++){
            if(comments[i].getCommentflag() == false){
                commentList.add(comments[i]);
            }
        }
        return  commentList;
    }
//
//    @ResponseBody
//    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
//    public Comment[] showCommentInCenter(@PathVariable int userId){
//       return commentService.showComments(userId);
//
//    }

    @ResponseBody
    @RequestMapping(value = "/{commenterId}/{saleGoodsId}",method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int commenterId,
                                @PathVariable int saleGoodsId){
        commentService.deleteComment(commenterId,saleGoodsId);
        //return "delete comment";
    }

    @ResponseBody
    @RequestMapping(value = "/saleGoodsId/{saleGoodsId}",method = RequestMethod.GET)
    public List<Comment> getComment(@PathVariable int saleGoodsId){
        //System.out.println(saleGoodsId);
        List<Comment> commentList = commentService.getCommentByGoodsId(saleGoodsId);
        System.out.println(commentList.size());
        return commentList;
    }
}

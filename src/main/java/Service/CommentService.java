package Service;

import Dao.dao.CommentMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.dao.UserMapper;
import Dao.model.Comment;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class CommentService {
    @Autowired(required = false)
    CommentMapper commentMapper;

    @Autowired(required = false)
    SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(CommentService.class);

    public String saveComments(String commentText, int commenterId, int goodsId){
        try {
            Comment comment = new Comment();
            comment.setCommenttext(commentText);
            comment.setCommenterid(commenterId);
            comment.setSalegoodsid(goodsId);
            //comment.setBuygoodsid(goodsId);
            comment.setCommentflag(false);
            comment.setCommenttime(new Date());
            comment.setReadflag(true);
            commentMapper.insert(comment);

            SaleGoods goods = saleGoodsMapper.selectByPrimaryKey(goodsId);
            comment.setCommenterid(goods.getUserid());
            comment.setCommentflag(true);
            comment.setReadflag(false);
            commentMapper.insert(comment);

            return "insert 2 comments into DB";
        }
        catch (Exception ex){
            logger.error("exception in CommentService.save", ex);
            System.out.println(ex.getMessage());
            return "Exception in CommentService";
        }
    }

    public Comment[] showComments(int commenterId){
        try {
            List<Comment> list = commentMapper.selectByCommenterId(commenterId);
            Comment[] comments = new Comment[list.size()];
            for(int i = 0; i < list.size(); i++){
                comments[i] = list.get(i);
            }
            return comments;
        }
        catch (Exception ex){
            logger.error("exception in CommentService.show", ex);
            //System.out.println(ex.getMessage());
            //return "Exception in CommentService.show";
            return null;
        }
    }

    public String modifyReadFlag(int commenterId, int saleGoodsId){
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("commenterId",commenterId);
            map.put("saleGoodsId",saleGoodsId);
            Comment comment = commentMapper.selectByUserIdAndGoodsId(map);
            comment.setReadflag(true);
            commentMapper.updateByPrimaryKeySelective(comment);
            return "update read flag";
        }
        catch (Exception ex){
            logger.error("exception in CommentService.flag", ex);
            //System.out.println(ex.getMessage());
            return "Exception in CommentService.flag";
        }
    }

    public void deleteComment(int commenterId, int saleGoodsId){
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("commenterId",commenterId);
            map.put("saleGoodsId",saleGoodsId);
            Comment comment = commentMapper.selectByUserIdAndGoodsId(map);
            commentMapper.delete(comment);
            //return "delete";
        }
        catch (Exception ex){
            logger.error("exception in CommentService.delete", ex);
            //System.out.println(ex.getMessage());
            //return "Exception in CommentService.delete";
        }
    }

    public List<Comment> getCommentByGoodsId(int saleGoodsId){
        //System.out.println(saleGoodsId);
        return commentMapper.selectBySaleGoodsId(saleGoodsId);
    }
}

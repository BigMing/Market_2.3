package Dao.dao;

import Dao.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    void deleteByPrimaryKey(Integer commentid);

    void insert(Comment record);

    void insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    void updateByPrimaryKeySelective(Comment record);

    void updateByPrimaryKey(Comment record);

    List<Comment> selectByCommenterId (int commenterId);


    Comment selectByUserIdAndGoodsId(Map<String,Object> map);

    void delete(Comment comment);

    List<Comment> selectBySaleGoodsId(int saleGoodsId);
}
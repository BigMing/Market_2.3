package Dao.model;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private String commenttext;

    private Integer commenterid;

    private Integer salegoodsid;

    private Date commenttime;

    private Boolean commentflag;

    private Integer buygoodsid;

    private Boolean readflag;



    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }

    public Integer getCommenterid() {
        return commenterid;
    }

    public void setCommenterid(Integer commenterid) {
        this.commenterid = commenterid;
    }

    public Integer getSalegoodsid() {
        return salegoodsid;
    }

    public void setSalegoodsid(Integer salegoodsid) {
        this.salegoodsid = salegoodsid;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Boolean getCommentflag() {
        return commentflag;
    }

    public void setCommentflag(Boolean commentflag) {
        this.commentflag = commentflag;
    }

    public Integer getBuygoodsid() {
        return buygoodsid;
    }

    public void setBuygoodsid(Integer buygoodsid) {
        this.buygoodsid = buygoodsid;
    }

    public Boolean getReadflag() {
        return readflag;
    }

    public void setReadflag(Boolean readflag) {
        this.readflag = readflag;
    }
//    private String commenter;
//
//    private  String userName;
//
//    private  String headline;
//    public void setUserName(String userName){
//        this.userName=userName;
//    }
//    public String getUserName(){
//        return userName;
//    }
//    public String getHeadline(){
//        return  headline;
//    }
//    public void setHeadline(String headline){
//        this.headline=headline;
//    }
//    public String getCommenter() {
//        return commenter;
//    }
//
//    public void setCommenter(String commenter) {
//        this.commenter = commenter;
//    }
}
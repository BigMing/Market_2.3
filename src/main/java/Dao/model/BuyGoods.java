package Dao.model;

import java.util.Date;

public class BuyGoods {
    private Integer buygoodsid;

    private String headline;

    private String contactor;

    private String phonenumber;

    private Date posttime;

    private Integer sdid;

    private String tradeplace;

    private Double price;

    private Integer tradeplaceid;

    private String description;

    private Integer goodsflag;

    private Integer userid;

    public Integer getBuygoodsid() {
        return buygoodsid;
    }

    public void setBuygoodsid(Integer buygoodsid) {
        this.buygoodsid = buygoodsid;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Integer getSdid() {
        return sdid;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public String getTradeplace() {
        return tradeplace;
    }

    public void setTradeplace(String tradeplace) {
        this.tradeplace = tradeplace == null ? null : tradeplace.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTradeplaceid() {
        return tradeplaceid;
    }

    public void setTradeplaceid(Integer tradeplaceid) {
        this.tradeplaceid = tradeplaceid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getGoodsflag() {
        return goodsflag;
    }

    public void setGoodsflag(Integer goodsflag) {
        this.goodsflag = goodsflag;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
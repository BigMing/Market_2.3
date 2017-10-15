package Dao.model;

import java.util.Date;

public class SaleGoods {
    private Integer salegoodsid;

    private String headline;

    private Double price;

    private String description;

    private String tradeplace;

    private String phonenumber;

    private Date posttime;

    private String contactor;

    private Integer sdid;

    private Integer userid;

    private Integer tradeplaceid;

    private Integer goodsflag;

    private String goodsImage;

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    private String[] locations;

    public void setGoodsImage(String goodsImage){
        this.goodsImage=goodsImage;
    }
    public String getGoodsImage(){
        return goodsImage;
    }

    public Integer getSalegoodsid() {
        return salegoodsid;
    }

    public void setSalegoodsid(Integer salegoodsid) {
        this.salegoodsid = salegoodsid;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTradeplace() {
        return tradeplace;
    }

    public void setTradeplace(String tradeplace) {
        this.tradeplace = tradeplace == null ? null : tradeplace.trim();
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

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    public Integer getSdid() {
        return sdid;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTradeplaceid() {
        return tradeplaceid;
    }

    public void setTradeplaceid(Integer tradeplaceid) {
        this.tradeplaceid = tradeplaceid;
    }

    public Integer getGoodsflag() {
        return goodsflag;
    }

    public void setGoodsflag(Integer goodsflag) {
        this.goodsflag = goodsflag;
    }
}
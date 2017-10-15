package Dao.model;

public class HotGoods {
    private Integer hotgoodsid;

    private Integer salegoodsid;

    private String hotgoodsimage;

    public Integer getHotgoodsid() {
        return hotgoodsid;
    }

    public void setHotgoodsid(Integer hotgoodsid) {
        this.hotgoodsid = hotgoodsid;
    }

    public Integer getSalegoodsid() {
        return salegoodsid;
    }

    public void setSalegoodsid(Integer salegoodsid) {
        this.salegoodsid = salegoodsid;
    }

    public String getHotgoodsimage() {
        return hotgoodsimage;
    }

    public void setHotgoodsimage(String hotgoodsimage) {
        this.hotgoodsimage = hotgoodsimage == null ? null : hotgoodsimage.trim();
    }
}
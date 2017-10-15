package Dao.model;

public class GoodsImage {
    private Integer giid;

    private String goodsimage;

    private Integer salegoodsid;

    public Integer getGiid() {
        return giid;
    }

    public void setGiid(Integer giid) {
        this.giid = giid;
    }

    public String getGoodsimage() {
        return goodsimage;
    }

    public void setGoodsimage(String goodsimage) {
        this.goodsimage = goodsimage == null ? null : goodsimage.trim();
    }

    public Integer getSalegoodsid() {
        return salegoodsid;
    }

    public void setSalegoodsid(Integer salegoodsid) {
        this.salegoodsid = salegoodsid;
    }
}
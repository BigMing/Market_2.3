package Dao.model;

public class TradePlace {
    private Integer tradeplaceid;

    private String tradeplace;

    public Integer getTradeplaceid() {
        return tradeplaceid;
    }

    public void setTradeplaceid(Integer tradeplaceid) {
        this.tradeplaceid = tradeplaceid;
    }

    public String getTradeplace() {
        return tradeplace;
    }

    public void setTradeplace(String tradeplace) {
        this.tradeplace = tradeplace == null ? null : tradeplace.trim();
    }
}
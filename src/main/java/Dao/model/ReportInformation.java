package Dao.model;

import java.util.Date;

public class ReportInformation {
    private Integer informationid;

    private String description;

    private Integer salegoodsid;

    private Date reporttime;

    private Integer reporterid;

    public Integer getInformationid() {
        return informationid;
    }

    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSalegoodsid() {
        return salegoodsid;
    }

    public void setSalegoodsid(Integer salegoodsid) {
        this.salegoodsid = salegoodsid;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public Integer getReporterid() {
        return reporterid;
    }

    public void setReporterid(Integer reporterid) {
        this.reporterid = reporterid;
    }
}
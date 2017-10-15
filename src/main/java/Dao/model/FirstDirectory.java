package Dao.model;

public class FirstDirectory {
    private Integer fdid;

    private String fdname;

    public Integer getFdid() {
        return fdid;
    }

    public void setFdid(Integer fdid) {
        this.fdid = fdid;
    }

    public String getFdname() {
        return fdname;
    }

    public void setFdname(String fdname) {
        this.fdname = fdname == null ? null : fdname.trim();
    }
}
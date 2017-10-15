package Dao.model;

import java.util.Date;

public class SendEmail {
    private Integer sendemailid;

    private Date requesttime;

    private Boolean validflag;

    private String randomnumber;

    private String email;

    private Integer userid;

    public Integer getSendemailid() {
        return sendemailid;
    }

    public void setSendemailid(Integer sendemailid) {
        this.sendemailid = sendemailid;
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
    }

    public Boolean getValidflag() {
        return validflag;
    }

    public void setValidflag(Boolean validflag) {
        this.validflag = validflag;
    }

    public String getRandomnumber() {
        return randomnumber;
    }

    public void setRandomnumber(String randomnumber) {
        this.randomnumber = randomnumber == null ? null : randomnumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
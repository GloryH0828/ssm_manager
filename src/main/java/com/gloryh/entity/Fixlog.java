package com.gloryh.entity;



import java.util.Date;

public class Fixlog {
    private int id;
    private String workername;
    private String username;
    private String toolname;
    private int toolcount;
    private String partsname;
    private int partscount;
    private Date borrowtime;
    private Date returntime;
    private int state;
    private int cost;
    private String productname;
    private String reason;
    private Date time;
    private int bonus;
    private String oldparts;
    private int opcount;
    private String customername;
    private String customerphone;
    private String customeraddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public int getToolcount() {
        return toolcount;
    }

    public void setToolcount(int toolcount) {
        this.toolcount = toolcount;
    }

    public String getPartsname() {
        return partsname;
    }

    public void setPartsname(String partsname) {
        this.partsname = partsname;
    }

    public int getPartscount() {
        return partscount;
    }

    public void setPartscount(int partscount) {
        this.partscount = partscount;
    }

    public Date getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getOldparts() {
        return oldparts;
    }

    public void setOldparts(String oldparts) {
        this.oldparts = oldparts;
    }

    public int getOpcount() {
        return opcount;
    }

    public void setOpcount(int opcount) {
        this.opcount = opcount;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    @Override
    public String toString() {
        return "Fixlog{" +
                "id=" + id +
                ", workername='" + workername + '\'' +
                ", username='" + username + '\'' +
                ", toolname='" + toolname + '\'' +
                ", toolcount=" + toolcount +
                ", partsname='" + partsname + '\'' +
                ", partscount=" + partscount +
                ", borrowtime=" + borrowtime +
                ", returntime=" + returntime +
                ", state=" + state +
                ", cost=" + cost +
                ", productname='" + productname + '\'' +
                ", reason='" + reason + '\'' +
                ", time=" + time +
                ", bonus=" + bonus +
                ", oldparts='" + oldparts + '\'' +
                ", opcount=" + opcount +
                ", customername='" + customername + '\'' +
                ", customerphone='" + customerphone + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                '}';
    }
}

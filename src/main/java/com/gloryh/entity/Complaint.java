package com.gloryh.entity;


public class Complaint {
    private int id;
    private String productname;
    private String reason;
    private String customername;
    private String phone;
    private String address;
    private int state;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", reason='" + reason + '\'' +
                ", customername='" + customername + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", type=" + type +
                '}';
    }
}

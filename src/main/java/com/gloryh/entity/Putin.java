package com.gloryh.entity;


import java.util.Date;

public class Putin {
    private int id;
    private String name;
    private int price;
    private String use;
    private Date time;
    private int state;
    private int count;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Putin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", use='" + use + '\'' +
                ", time=" + time +
                ", state=" + state +
                ", count=" + count +
                ", type=" + type +
                '}';
    }
}

package com.thread.responsetype.service.usermodel;

import com.thread.responsetype.entity.Item;

public class Odermodel {
    //商品订单号
    private String id;
    //用户id
    private Integer userid;
    //商品id
    private Integer itemid;
    //购买数量
    private Integer amount;
    //购买金额
    private double orderprice;
    //购买单价
    private double itemprice;

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }
}

package com.thread.responsetype.service;

import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.usermodel.Itemmodel;

import java.util.List;

public interface itemservice {
    //创建商品对象
    Itemmodel createitem(Itemmodel itemmodel) throws Mexception;
    //浏览商品列表
    List<Itemmodel> listitem();
    //商品详情浏览
    Itemmodel getitembyid(Integer id);


}

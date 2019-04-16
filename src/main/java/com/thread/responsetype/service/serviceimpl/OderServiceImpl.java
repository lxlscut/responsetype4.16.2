package com.thread.responsetype.service.serviceimpl;

import com.thread.responsetype.dao.orderinfoMapper;
import com.thread.responsetype.entity.orderinfo;
import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.OrderService;
import com.thread.responsetype.service.UserService;
import com.thread.responsetype.service.itemservice;
import com.thread.responsetype.service.usermodel.Itemmodel;
import com.thread.responsetype.service.usermodel.Odermodel;
import com.thread.responsetype.service.usermodel.Usermodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OderServiceImpl implements OrderService {

    @Autowired
    private UserService serv;
    @Autowired
    private itemservice itserv;
    @Autowired
    private orderinfoMapper odM;
    @Override
    @Transactional
    public Odermodel createorder(Integer userid, Integer itemid, Integer amout) throws Mexception {
        //校验下单状态，商品是否存在，用户是否合法，数量是否正确
        Itemmodel itemmodel = itserv.getitembyid(itemid);
        if(itemmodel == null){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"商品不存在");
        }
        Usermodel usermodel = new Usermodel();
        usermodel = serv.selectByPrimaryKey(userid);
        if(usermodel == null){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"用户不存在");
        }
        if(amout<=0||amout>99){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"数量信息不正确");
        }
        //落单减库存
      boolean i =  itserv.stockdecrease(itemid,amout);
        if(!i){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"库存不足");
        }
        //订单入库
        //先创建一个交易订单
            Odermodel odermodel = new Odermodel();
        odermodel.setUserid(userid);
        odermodel.setItemid(itemid);
        odermodel.setAmount(amout);
        odermodel.setItemprice(itemmodel.getPrice());
        odermodel.setOrderprice(itemmodel.getPrice()*amout);
        //生成交易订单号

        orderinfo od = this.convertfrommodel(odermodel);
        odM.insertSelective(od);
        //返回前端
        return null;
    }

    private  orderinfo convertfrommodel(Odermodel odermodel){
        if(odermodel == null){
            return  null;
        }
        orderinfo od = new orderinfo();
        BeanUtils.copyProperties(odermodel,od);
        return od;
    }
    //生成订单号
    private  String ordergen(){
        //前八位为时间年月日

        //中间6位为自增数列

        //最后两位为分库分表位，将固定的用户信息放到不同的库与表，减轻压力

        return null;
    }

}

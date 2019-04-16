package com.thread.responsetype.service.serviceimpl;

import com.thread.responsetype.dao.ItemMapper;
import com.thread.responsetype.dao.StockMapper;
import com.thread.responsetype.entity.Item;
import com.thread.responsetype.entity.Stock;
import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.itemservice;
import com.thread.responsetype.service.usermodel.Itemmodel;
import com.thread.responsetype.validation.ValidationResult;
import com.thread.responsetype.validation.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements itemservice {
    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private ItemMapper im;
    @Autowired
    private StockMapper sm;

    @Override
    @Transactional
    public Itemmodel createitem(Itemmodel itemmodel) throws Mexception {
        //校验结果
        ValidationResult VR  = validator.vr(itemmodel);
        if(VR.isIshaserror()){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,VR.geterrmsg());
        }
        //转化model为object
            Item item = this.convert(itemmodel);
            Stock stock = new Stock();
            im.insertSelective(item);
            itemmodel.setId(item.getId());
            stock = this.modelconvertstock(itemmodel);
            sm.insertSelective(stock);

        //将转化结果存入数据库当中
        System.out.println(itemmodel.getId());
        //返回创建完成的对象
        return this.getitembyid(itemmodel.getId());
    }

    @Override
    public List<Itemmodel> listitem() {

        List<Item> list= im.select();
            List<Itemmodel> list1 =  list.stream().map(item->{
            Stock stock = sm.selectByItemId(item.getId());
            Itemmodel itemmodel = this.convertmodel(item,stock);
            return itemmodel;
        }).collect(Collectors.toList());
        return list1;
    }

    @Override
    public Itemmodel getitembyid(Integer id) {
        Item IT = new Item();
        Stock st = new Stock();
        IT = im.selectByPrimaryKey(id);
        st = sm.selectByItemId(IT.getId());
        Itemmodel  itemmodel = convertmodel(IT,st);
        return itemmodel;
    }


    public Item convert(Itemmodel itemmodel){
        if(itemmodel == null){
            return null;
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemmodel,item);
        return item;
    }

    public Stock modelconvertstock(Itemmodel itemmodel){
        if(itemmodel == null){
            return null;
        }
        Stock stock = new Stock();
        stock.setStock(itemmodel.getStock());
        stock.setItemId(itemmodel.getId());
        return stock;
    }

    private  Itemmodel convertmodel(Item item,Stock stock){
        Itemmodel itemmodel = new Itemmodel();
        BeanUtils.copyProperties(item,itemmodel);
        BeanUtils.copyProperties(stock,itemmodel);
        return itemmodel;
    }


}

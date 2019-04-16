package com.thread.responsetype.controller;

import com.thread.responsetype.controller.viewobject.ItemView;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import com.thread.responsetype.service.itemservice;
import com.thread.responsetype.service.usermodel.Itemmodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ItemController extends Basecontroller{
    @Autowired
    private itemservice itemserv;


    @RequestMapping("/create")
    @ResponseBody
    private responsetype createitem(@RequestParam(name = "title")String title,
                                    @RequestParam(name = "price")Integer price,
                                    @RequestParam(name = "stock")Integer stock,
                                    @RequestParam(name = "description")String description,
                                    @RequestParam(name = "url")String url) throws Mexception {
        responsetype rt = new responsetype();

        //根据请求参数来创建对象
        Itemmodel itemmodel = new Itemmodel();
        itemmodel.setTitle(title);
        itemmodel.setDescription(description);
        itemmodel.setPrice(price);
        itemmodel.setUrl(url);
        itemmodel.setStock(stock);
        //根据service层将数据存入数据库
        Itemmodel  returnmodel =  itemserv.createitem(itemmodel);
        ItemView itemView = modeltoview(returnmodel);
        return rt.create(itemView);
    }
    private ItemView modeltoview(Itemmodel itemmodel){
        if(itemmodel == null){
            return null;
        }
        ItemView itemView =new ItemView();
        BeanUtils.copyProperties(itemmodel,itemView);
        return itemView;
    }

    @RequestMapping("/getitem")
    @ResponseBody
    public  responsetype getitem(@RequestParam (name = "id") int id) throws Mexception {
        responsetype rt = new responsetype();
        Itemmodel itemmodel = new Itemmodel();
        itemmodel = itemserv.getitembyid(id);
        ItemView itemView = this.modeltoview(itemmodel);
        return rt.create(itemmodel);
    }

    @RequestMapping("/getitem1")
    public  String getitem1(@RequestParam (name = "id") int id, Map<String,Object> data) throws Mexception {
        responsetype rt = new responsetype();
        Itemmodel itemmodel = new Itemmodel();
        itemmodel = itemserv.getitembyid(id);
        ItemView itemView = this.modeltoview(itemmodel);
        data.put("DT",itemView);
        return "shangpin";
    }

    //查询所有商品
    @RequestMapping("/queryall")
    @ResponseBody
    public  responsetype getall(){
        responsetype rt = new responsetype();
        List<Itemmodel> itemmodels = itemserv.listitem();
        List<ItemView> viewList= itemmodels.stream().map(itemmodel -> {
            ItemView itemView =this.modeltoview(itemmodel);
            return itemView;
        }).collect(Collectors.toList());
        System.out.println(viewList);
        return rt.create(viewList);
    }



    @RequestMapping("/createview")
    public String createview(){
        return "createitem";
    }

    @RequestMapping("/showview")
    public String showview(){
        return "itemshow";
    }

    @RequestMapping("itemshow")
    public String itemshow(){
        return "itemdetail";
    }
}

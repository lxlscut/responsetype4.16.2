package com.thread.responsetype.service.usermodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Itemmodel {
    //商品id
    private Integer id;
    //商品名称
    @NotBlank(message = "商品名称不能为空")
    private String title;
    //商品价格

//    @NotBlank(message = "价格不能为空")
//    @Min(value = 0,message = "商品价格必须大于零")
    private double price;
    //商品的库存
    @NotNull(message = "库存不能不填写")
    @Min(value = 0,message = "库存必须大于零")
    private Integer stock;
    //商品的描述
    @NotBlank(message = "商品描述不能为空")
    private String description;
    //商品的销量
    private Integer sale;
    //商品的描述url
    @NotBlank(message = "商品描述不能为空")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Itemmodel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", sale=" + sale +
                ", url='" + url + '\'' +
                '}';
    }
}

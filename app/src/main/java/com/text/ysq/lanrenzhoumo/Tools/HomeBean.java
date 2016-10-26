package com.text.ysq.lanrenzhoumo.Tools;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/26 0026.
 */
public class HomeBean {
    private String front_cover_image_list;//图片
    private String title;//标题
    private String poi;//活动
    private String category;//分类
    private String time_info;//截止日期
    private String collected_num;//收藏数
    private String price;//价格

    public String getPicture() {
        return front_cover_image_list;
    }

    public void setPicture(String front_cover_image_list) {
        this.front_cover_image_list = front_cover_image_list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime_info() {
        return time_info;
    }

    public void setTime_info(String time_info) {
        this.time_info = time_info;
    }

    public String getCollected_num() {
        return collected_num;
    }

    public void setCollected_num(String collected_num) {
        this.collected_num = collected_num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public HomeBean(String front_cover_image_list, String title, String poi, String category, String time_info, String collected_num, String price) {
        this.front_cover_image_list = front_cover_image_list;
        this.title = title;
        this.poi = poi;
        this.category = category;
        this.time_info = time_info;
        this.collected_num = collected_num;
        this.price = price;
    }

    public HomeBean() {
        super();
    }
}

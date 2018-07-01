package com.zcl.alive.model.bean;

import java.io.Serializable;

public class NewsInfo implements Serializable {

    /**
     * uniquekey : f619018f81e59d3c49321d80584df59e
     * title : 付小芳20万大赛：杨帆强势零封，携郑宇伯代勇晋级！刘海涛遭逆转
     * date : 2018-06-26 20:50
     * category : 头条
     * author_name : 台球不闹腾
     * url : http://mini.eastday.com/mobile/180626205058806.html
     * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20180626/20180626205058_d1fcc5af25e3bc2d63bc940fc4916013_1_mwpm_03200403.jpg
     * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20180626/20180626205058_d1fcc5af25e3bc2d63bc940fc4916013_3_mwpm_03200403.jpg
     * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20180626/20180626205058_d1fcc5af25e3bc2d63bc940fc4916013_2_mwpm_03200403.jpg
     */

    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }
}

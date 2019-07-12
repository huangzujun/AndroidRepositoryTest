package com.example.best.myapplication.entity;

/**
 * 日期 2019-07-05
 */
public class ListViewItem {

    private String imgUrl;
    private String title;
    private String content;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ListViewItem{" +
                "imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

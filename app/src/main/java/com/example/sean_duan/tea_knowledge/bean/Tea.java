package com.example.sean_duan.tea_knowledge.bean;

/**
 * Created by sean-duan on 2017/7/18.
 */

public class Tea {
    public Tea(String id, String title, String source, String description, String wap_thump, String create_time, String nickname) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.description = description;
        this.wap_thump = wap_thump;
        this.create_time = create_time;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", description='" + description + '\'' +
                ", wap_thump='" + wap_thump + '\'' +
                ", create_time='" + create_time + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWap_thump() {
        return wap_thump;
    }

    public void setWap_thump(String wap_thump) {
        this.wap_thump = wap_thump;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String id ;
    private String title ;
    private String source ;
    private String description ;
    private String wap_thump ;
    private String create_time ;
    private String nickname ;

}

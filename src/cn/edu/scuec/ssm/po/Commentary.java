package cn.edu.scuec.ssm.po;

import java.util.Date;

public class Commentary {
    private Integer id;

    private Integer musicId;

    private Date commenttime;

    private Integer userId;

    private String article;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article == null ? null : article.trim();
    }
}
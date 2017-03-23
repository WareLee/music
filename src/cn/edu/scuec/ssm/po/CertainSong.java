package cn.edu.scuec.ssm.po;

import java.util.Date;
import java.util.List;

/**
 * 某一首歌的详情,以及与之关联的评论之类的综合
 * 
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class CertainSong extends Musicgarage {
	private String article; // 评论
	private String username; // 评论人
	private Date commenttime; // 评论发起时
	private int user_id; // 评论人的id

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}

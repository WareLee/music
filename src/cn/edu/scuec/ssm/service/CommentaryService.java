package cn.edu.scuec.ssm.service;

import java.util.List;

import cn.edu.scuec.ssm.po.Commentary;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public interface CommentaryService {

	// 发表对歌曲的评论
	public int insertComment(Commentary record);
	
	// 获取某一个歌曲的评论信息
	public List<Commentary> selectCertainCommentary(Integer id);

}
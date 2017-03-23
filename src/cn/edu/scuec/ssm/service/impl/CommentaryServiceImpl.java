package cn.edu.scuec.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.scuec.ssm.mapper.CommentaryMapper;
import cn.edu.scuec.ssm.mapper.MySEO;
import cn.edu.scuec.ssm.po.Commentary;
import cn.edu.scuec.ssm.service.CommentaryService;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryMapper  commentaryMapper;
	
	@Autowired
	private MySEO  mySEO;
	
	// 发表对歌曲的评论
	/* (non-Javadoc)
	 * @see cn.edu.scuec.ssm.service.impl.CommentaryService#insertComment(cn.edu.scuec.ssm.po.Commentary)
	 */
	@Override
	public int insertComment(Commentary record){
		 return commentaryMapper.insert(record);
	}

	@Override
	public List<Commentary> selectCertainCommentary(Integer music_id) {
		return mySEO.selectCommentListByMusicId(music_id);
	}

}

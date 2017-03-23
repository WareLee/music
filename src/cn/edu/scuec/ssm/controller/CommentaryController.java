package cn.edu.scuec.ssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scuec.ssm.po.CommentVoReturn;
import cn.edu.scuec.ssm.po.Commentary;
import cn.edu.scuec.ssm.po.Musicgarage;
import cn.edu.scuec.ssm.service.CommentaryService;
import cn.edu.scuec.ssm.service.SongService;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
@Controller
public class CommentaryController {
	
	@Autowired
	private CommentaryService commentaryService;
	
	@Autowired
	private SongService songService;
	
	// 发表针对某首歌曲的评论
	@RequestMapping(value="/doComment",method=RequestMethod.POST)
	public @ResponseBody CommentVoReturn comment(Commentary record) throws Exception {
		CommentVoReturn commentVoReturn=new CommentVoReturn();
		record.setCommenttime(new Date());
		
		// 检查该歌曲是否存在
		if(songService.getCertainSong(record.getMusicId()) == null){
			commentVoReturn.setCode(0);
			commentVoReturn.setMessage("该歌曲已不存在");
			commentVoReturn.setState(0);
			
			return commentVoReturn;
		}
		
		if(commentaryService.insertComment(record)>0){
			commentVoReturn.setCode(1);
			commentVoReturn.setState(1);
			commentVoReturn.setMessage("成功");
		}else{
			commentVoReturn.setCode(0);
			commentVoReturn.setMessage("评论失败");
			commentVoReturn.setState(0);
		}
		
		return commentVoReturn;
	}
	// 请求某首歌曲的评论
	@RequestMapping(value="/getComment")
	public @ResponseBody List<Commentary> getComment(Integer musicId) throws Exception {
		List<Commentary> commentaryList=null;
		
		if(musicId>0){
			commentaryList=commentaryService.selectCertainCommentary(musicId);
		}
		return commentaryList;
	}
	
	
}

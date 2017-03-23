package cn.edu.scuec.ssm.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scuec.ssm.po.Acollection;
import cn.edu.scuec.ssm.po.CertainSong;
import cn.edu.scuec.ssm.po.CommentVoReturn;
import cn.edu.scuec.ssm.po.Commentary;
import cn.edu.scuec.ssm.po.Download;
import cn.edu.scuec.ssm.po.Musicgarage;
import cn.edu.scuec.ssm.service.CommentaryService;
import cn.edu.scuec.ssm.service.SongService;
import cn.edu.scuec.ssm.utils.MusicSearchUtils;

import com.jspsmart.upload.SmartUpload;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private CommentaryService commentaryService;
	
	
	@RequestMapping(value="/selectSongList",method=RequestMethod.POST)
	public @ResponseBody List<Musicgarage> selectSongList(Integer from ,Integer offset) throws Exception {
		
		List<Musicgarage> musicList=null;
		if(from >=0 && offset>0){
			
			musicList=songService.getMusicList(from, offset);
			
			if(musicList.size()>0){
				return musicList;
			}
		}
		
		return musicList;
	} 
	
	/**
	 * 获取一首特定歌曲的详情
	 * @param id	歌曲的id
	 * @param newone 歌曲是否是外来的
	 * @param songname	如果歌曲是外来的就需要此信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectASong",method=RequestMethod.POST)
	public @ResponseBody List<CertainSong> selectASong(Integer musicId) throws Exception {
		List<Commentary> commentList=commentaryService.selectCertainCommentary(musicId);
		if(commentList==null || commentList.size()==0){
			return songService.getCertainSongNotFo(musicId);
		}
		return songService.getCertainSong(musicId);
	} 
	
	// 查找一首歌曲
	@RequestMapping(value="/searchASong",method=RequestMethod.POST)
	public @ResponseBody List<Musicgarage> searchSong(String songtitle) throws Exception {
		
		List<Musicgarage> musicList= songService.searchSong(songtitle);
		
		if(musicList==null || musicList.size()==0){		// 如果没查到
			// 模拟请求获取第三方的相关信息
			MusicSearchUtils searchUtils=new MusicSearchUtils(songtitle);
			Musicgarage oneSong=searchUtils.execute();
			
			if(oneSong!=null){
				musicList=songService.searchSong(oneSong.getSongtitle());
				if(musicList==null || musicList.size()==0){
					songService.insertToGarage(oneSong);
					return songService.searchSong(oneSong.getSongtitle());
				}
				
			}
			
		}
		
		return musicList;
	} 
	
	/**
	 * 收藏歌曲
	 * @param record
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/collectASong",method=RequestMethod.POST)
	public @ResponseBody CommentVoReturn collectASong(Acollection record) throws Exception {
		CommentVoReturn commentVoReturn=new CommentVoReturn();
		
		if(record.getMusicId()>0){	
			int exist=songService.selectAxollection(record).size();
			if(exist<1){
				if(songService.collectSong(record)>0){
					commentVoReturn.setCode(1);
					commentVoReturn.setMessage("成功");
					commentVoReturn.setState(1);
				}
			}else{
				commentVoReturn.setCode(1);
				commentVoReturn.setMessage("已存在");
				commentVoReturn.setState(1);
			}
		}else{
			commentVoReturn.setCode(0);
			commentVoReturn.setMessage("失败,请重试");
			commentVoReturn.setState(0);
		}
		return commentVoReturn;
	} 
	
	@RequestMapping(value="/downloadASong",method=RequestMethod.POST)
	public void downloadASong(HttpServletRequest request,HttpServletResponse response,Download record) throws Exception {
//		System.out.println("-------");
		// 查询要下载的歌曲是否存在
		Musicgarage musicgarage=null;
		if(record.getMusicId()>0){
			musicgarage=songService.selectASongById(record.getMusicId());
		}
		
		String songaddress=null;
		if(musicgarage!=null){
			// 在download表中添加记录
			songService.insertADownload(record);
			// 歌曲地址
			songaddress=musicgarage.getSongaddress();
			
		}
		
//		if(musicgarage!=null && musicgarage.getSongaddress().indexOf("http:")<0){
//			System.out.println(musicgarage.getSongaddress());
//			request.setCharacterEncoding("utf-8");
//	        
//	        String filename = musicgarage.getSongaddress();
//	        
//	        String urlname = URLEncoder.encode(filename, "utf-8");//防止文件名中有中文乱码
//	        response.setHeader("Content-Disposition","attachment;filename="+urlname);
//	        
//	        FileInputStream fis = new FileInputStream(new File(request.getSession().getServletContext().getRealPath(filename)));
//	        BufferedInputStream bis = new BufferedInputStream(fis);
//	        ServletOutputStream sos = response.getOutputStream();
//	        
//	        byte[] buffer = new byte[1024];
//	        int len=0;
//	        while((len=bis.read(buffer, 0, 1024))!=-1){
//	            sos.write(buffer, 0, len);
//	        }
//	        bis.close();
//	        fis.close();
//		}
		
		
        
//		SmartUpload su = new SmartUpload();
//		su.initialize();
//
//		su.setContentDisposition(null); //表示这是一个下载操作
//		su.downloadFile("images/1.jpg");
		
	} 
	
	@RequestMapping(value="/deleteAcollection",method=RequestMethod.POST)
	public @ResponseBody CommentVoReturn deleteAcollection(Integer musicId) throws Exception {
		CommentVoReturn commentVoReturn=new CommentVoReturn();
		
		if(musicId > 0){
			songService.deleteAcollection(musicId);
			commentVoReturn.setCode(1);
			commentVoReturn.setMessage("成功");
			commentVoReturn.setState(1);
		}else{
			commentVoReturn.setCode(0);
			commentVoReturn.setMessage("失败,请重试");
			commentVoReturn.setState(0);
		}
		return commentVoReturn;
	} 
	@RequestMapping(value="/inserttogarage",method=RequestMethod.POST)
	public @ResponseBody CommentVoReturn insertToGarage(Musicgarage record) throws Exception {
		CommentVoReturn commentVoReturn=new CommentVoReturn();
		
		if(record != null){
			if(songService.insertToGarage(record)>0){
				commentVoReturn.setCode(1);
				commentVoReturn.setMessage("成功");
				commentVoReturn.setState(1);
			}
		}else{
			commentVoReturn.setCode(0);
			commentVoReturn.setMessage("失败,请重试");
			commentVoReturn.setState(0);
		}
		return commentVoReturn;
	} 
	
	@RequestMapping(value="/selectCollectionList",method=RequestMethod.POST)
	public @ResponseBody  List<Musicgarage> selectCollectionList(Integer userId) {
		if(userId>0){
			return songService.selectCollectionListByUserid(userId);
		}
		return null;
	}
	@RequestMapping(value="/selectDownloadList",method=RequestMethod.POST)
	public @ResponseBody  List<Musicgarage> selectDownloadListByUserid(Integer userId) {
		if(userId>0){
			return songService.selectDownloadListByUserid(userId);
		}
		return null;
	}
	
	// 获取评论过的列表
	@RequestMapping(value="/getCommentedSongList",method=RequestMethod.POST)
	public @ResponseBody List<Musicgarage> getCommentedSongList(Integer userId) throws Exception {
		
		if(userId>0){
			return songService.getCommentedSongList(userId);
			
		}
		
		return null;
	}
		
}








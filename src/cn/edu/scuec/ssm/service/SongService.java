package cn.edu.scuec.ssm.service;

import java.util.List;

import cn.edu.scuec.ssm.po.Acollection;
import cn.edu.scuec.ssm.po.CertainSong;
import cn.edu.scuec.ssm.po.Download;
import cn.edu.scuec.ssm.po.Musicgarage;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public interface SongService {

	// 有一个小小的问题: 实际上,数据表中的id号可能是不连续的
	public List<Musicgarage> getMusicList(Integer from, Integer offset);
	
	// 获取我评论过的曲目
	public List<Musicgarage> getCommentedSongList(Integer userId);
	
	
	// 查询某一个具体的歌曲的详情,包括评论信息
	public List<CertainSong> getCertainSong(Integer id);

	//获取不含评论信息的certainSong
	public List<CertainSong> getCertainSongNotFo(Integer id);
	
	// 收藏歌曲
	public int collectSong(Acollection record);

	
	// 删除一个收藏
	int deleteAcollection(Integer music_id);
	
	// 插入一个下载记录
	int insertADownload(Download record);
	
	// 查询是否存在某个收藏
	List<Acollection> selectAxollection(Acollection acollection);
	
	
	// 向歌曲库中添加歌曲信息
	int insertToGarage(Musicgarage record);
	
	// 查询我的收藏
	List<Musicgarage> selectCollectionListByUserid(Integer userId);
	
	// 查询我的下载
	List<Musicgarage> selectDownloadListByUserid(Integer userId);
	
	// 根据歌曲id获取歌曲本身信息
	Musicgarage selectASongById(Integer id);
	
	// 根据歌名查找歌曲
	List<Musicgarage> searchSong(String songtitle);
	
}
package cn.edu.scuec.ssm.mapper;

import java.util.List;

import cn.edu.scuec.ssm.po.Acollection;
import cn.edu.scuec.ssm.po.CertainSong;
import cn.edu.scuec.ssm.po.Commentary;
import cn.edu.scuec.ssm.po.Musicgarage;

/**
 * 用于综合查询
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public interface MySEO {

	// 查询某首歌曲的详情,以及相应的评论信息
	public List<CertainSong> selectCertaionSongSeo(Integer id);
	
	// 获取不含评论信息的certainSong
	public List<CertainSong> selectCertaionSongNotFo(Integer id);
	
	// 删除一个收藏的歌曲
	public int deleteAcollection(Integer musicid);
	
	// 查询收藏的某歌曲是否存在
	public List<Acollection> selectAcollection(Acollection record);
	
	// 根据歌曲music_id查询评论信息
	public List<Commentary> selectCommentListByMusicId(Integer musicid);
	
	
	// 查询我的收藏
	public List<Musicgarage> selectCollectionListByUserid(Integer userId);
	
	// 查询我的下载
	public List<Musicgarage> selectDownloadListByUserid(Integer userId);
	
	// 根据歌名查找歌曲
	public List<Musicgarage> searchSong(String songtitle);
	
	// 查询我评论过的歌曲目录
	public List<Musicgarage> selectCommentedSongListByUserid(int userId);
	
}

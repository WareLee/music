package cn.edu.scuec.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.scuec.ssm.mapper.AcollectionMapper;
import cn.edu.scuec.ssm.mapper.DownloadMapper;
import cn.edu.scuec.ssm.mapper.MusicgarageMapper;
import cn.edu.scuec.ssm.mapper.MySEO;
import cn.edu.scuec.ssm.po.Acollection;
import cn.edu.scuec.ssm.po.CertainSong;
import cn.edu.scuec.ssm.po.Download;
import cn.edu.scuec.ssm.po.Musicgarage;
import cn.edu.scuec.ssm.po.MusicgarageExample;
import cn.edu.scuec.ssm.service.SongService;

/**
 * @param
 * @return
 * @throws Exception
 */
public class SongServiceImpl implements SongService {
	@Autowired
	private MusicgarageMapper musicgarageMapper;
	
	@Autowired
	private AcollectionMapper acollectionMapper;
	
	@Autowired
	private MySEO myseo;

	@Autowired
	private DownloadMapper downloadMapper;
	
	// 有一个小小的问题: 实际上,数据表中的id号可能是不连续的
	/* (non-Javadoc)
	 * @see cn.edu.scuec.ssm.service.impl.SongService#getMusicList(int, int)
	 */
	@Override
	public List<Musicgarage> getMusicList(Integer from , Integer offset){
		
		// 联合查询
		MusicgarageExample example=new MusicgarageExample();
		example.setDistinct(false);
		example.setOrderByClause("id ASC");
		
		MusicgarageExample.Criteria criteria= example.createCriteria();
		criteria.andIdBetween(from, from+offset);
		
		
		return musicgarageMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<CertainSong> getCertainSong(Integer id) {
		if(id>0){
			return  myseo.selectCertaionSongSeo(id);
		}
		return null;
	}

	@Override
	public int collectSong(Acollection record) {
		return acollectionMapper.insert(record);
	}
	
	// 删除一个收藏的音乐
	@Override
	public int deleteAcollection(Integer music_id) {
		
		return myseo.deleteAcollection(music_id);
	}

	// 查询是否存在某一个收藏的歌曲
	@Override
	public List<Acollection> selectAxollection(Acollection acollection) {
		return myseo.selectAcollection(acollection);
	}

	@Override
	public int insertToGarage(Musicgarage record) {
		return musicgarageMapper.insert(record);
	}
	
	// 查询收藏的所有歌曲的一个列表
	public List<Musicgarage> selectCollectionListByUserid(Integer userId){
		
		return myseo.selectCollectionListByUserid(userId);
	}
	
	// 查询下载过的所有歌曲的一个列表
	public List<Musicgarage> selectDownloadListByUserid(Integer userId){
		
		return myseo.selectDownloadListByUserid(userId);
	}

	@Override
	public Musicgarage selectASongById(Integer id) {
		
		return musicgarageMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertADownload(Download record) {
		return downloadMapper.insert(record);
	}

	@Override
	public List<Musicgarage> searchSong(String songtitle) {
		
		return myseo.searchSong(songtitle);
	}

	@Override
	public List<Musicgarage> getCommentedSongList(Integer userId) {
		return myseo.selectCommentedSongListByUserid(userId);
	}

	@Override
	public List<CertainSong> getCertainSongNotFo(Integer id) {
		return myseo.selectCertaionSongNotFo(id);
	}

}

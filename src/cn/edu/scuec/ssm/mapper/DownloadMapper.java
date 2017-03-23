package cn.edu.scuec.ssm.mapper;

import cn.edu.scuec.ssm.po.Download;
import cn.edu.scuec.ssm.po.DownloadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DownloadMapper {
    int countByExample(DownloadExample example);

    int deleteByExample(DownloadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Download record);

    int insertSelective(Download record);

    List<Download> selectByExample(DownloadExample example);

    Download selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Download record, @Param("example") DownloadExample example);

    int updateByExample(@Param("record") Download record, @Param("example") DownloadExample example);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);
}
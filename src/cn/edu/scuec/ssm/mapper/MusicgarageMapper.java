package cn.edu.scuec.ssm.mapper;

import cn.edu.scuec.ssm.po.Musicgarage;
import cn.edu.scuec.ssm.po.MusicgarageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicgarageMapper {
    int countByExample(MusicgarageExample example);

    int deleteByExample(MusicgarageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musicgarage record);

    int insertSelective(Musicgarage record);

    List<Musicgarage> selectByExampleWithBLOBs(MusicgarageExample example);

    List<Musicgarage> selectByExample(MusicgarageExample example);

    Musicgarage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musicgarage record, @Param("example") MusicgarageExample example);

    int updateByExampleWithBLOBs(@Param("record") Musicgarage record, @Param("example") MusicgarageExample example);

    int updateByExample(@Param("record") Musicgarage record, @Param("example") MusicgarageExample example);

    int updateByPrimaryKeySelective(Musicgarage record);

    int updateByPrimaryKeyWithBLOBs(Musicgarage record);

    int updateByPrimaryKey(Musicgarage record);
}
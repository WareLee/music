package cn.edu.scuec.ssm.mapper;

import cn.edu.scuec.ssm.po.Commentary;
import cn.edu.scuec.ssm.po.CommentaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentaryMapper {
    int countByExample(CommentaryExample example);

    int deleteByExample(CommentaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commentary record);

    int insertSelective(Commentary record);

    List<Commentary> selectByExampleWithBLOBs(CommentaryExample example);

    List<Commentary> selectByExample(CommentaryExample example);

    Commentary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commentary record, @Param("example") CommentaryExample example);

    int updateByExampleWithBLOBs(@Param("record") Commentary record, @Param("example") CommentaryExample example);

    int updateByExample(@Param("record") Commentary record, @Param("example") CommentaryExample example);

    int updateByPrimaryKeySelective(Commentary record);

    int updateByPrimaryKeyWithBLOBs(Commentary record);

    int updateByPrimaryKey(Commentary record);
}
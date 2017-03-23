package cn.edu.scuec.ssm.mapper;

import cn.edu.scuec.ssm.po.Acollection;
import cn.edu.scuec.ssm.po.AcollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcollectionMapper {
    int countByExample(AcollectionExample example);

    int deleteByExample(AcollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Acollection record);

    int insertSelective(Acollection record);

    List<Acollection> selectByExample(AcollectionExample example);

    Acollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Acollection record, @Param("example") AcollectionExample example);

    int updateByExample(@Param("record") Acollection record, @Param("example") AcollectionExample example);

    int updateByPrimaryKeySelective(Acollection record);

    int updateByPrimaryKey(Acollection record);
}
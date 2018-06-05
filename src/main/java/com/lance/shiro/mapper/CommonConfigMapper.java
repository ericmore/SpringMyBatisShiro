package com.lance.shiro.mapper;

import com.lance.shiro.entity.ICommonConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonConfigMapper {

    @Select("select * from i_commonConfig  where cKey = #{cKey}")
    List<ICommonConfig> findCommonConfigs(String cKey);

}

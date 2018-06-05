package com.lance.shiro.mapper;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper
public interface ContentMapper {
    //增加
    @Insert(" insert into i_content(module,title,content1,content2,content3,createTime,updateTime) " +
            "values(#{module},#{title},#{content1},#{content2},#{content3},now(),now())")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int add(IContent content);

    //查询
    @Select("select * from i_content where module=#{module}")
    IContent findByModule(String module);

    //更新
    @Update("update i_content set module=#{module},title=#{title},content1=#{content1},content2=#{content2},content3=#{content3},updateTime=now() where module=#{module}")
    int  update(IContent content);

    //获取
    @Select("select * from i_content where id = #{id} ")
    IContent get(@Param("id") int id);

}

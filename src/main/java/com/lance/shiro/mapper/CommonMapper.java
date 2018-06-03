package com.lance.shiro.mapper;

import com.lance.shiro.entity.IRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Select("select code,name from i_region where parentCode = '0' and status = '0' ")
    List<IRegion> findCountry();

    @Select("select code,name from i_region where parentCode=#{country} and status = '0' order by code asc ")
    List<IRegion> findState(String country);

    @Select("select t.code,t.name from i_region t where t.parentCode in (select tt.code from i_region tt" +
            " where tt.parentCode=#{country} and tt.status = '0') " +
            "and t.parentCode=#{state} and t.status = '0'  order by t.code asc ")
    List<IRegion> findCity(@Param("country")String country,@Param("state")String state);
}

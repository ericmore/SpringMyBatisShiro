package com.lance.shiro.mapper;

import com.lance.shiro.entity.IRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {
    //根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
    @Select("select code,name from i_region where parentCode = '0' and status = '0' ")
    List<IRegion> findCountry();

    @Select("select code,name from i_region where parentCode =#{country} and status = '0' order by code asc ")
    List<IRegion> findState(String country);

    @Select("select * from i_region where parentCode = #{state} and status = '0' " +
            "and parentCode in (select code from i_region where parentCode = #{country} and status = '0')  order by code asc ")
    List<IRegion> findCity(String country, String state);
}

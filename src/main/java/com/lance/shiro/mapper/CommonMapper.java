package com.lance.shiro.mapper;

import com.lance.shiro.entity.IRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Select("select distinct  country_iso_code,country_name from i_region\n")
    List<IRegion> findCountry();

    @Select("select distinct subdivision_1_iso_code, subdivision_1_name from i_region where country_iso_code='AU' and subdivision_1_iso_code is not null order by subdivision_1_iso_code asc")
    List<IRegion> findState(String country);

    @Select("select distinct city_name from i_region where country_iso_code=#{country} and city_name is not null and subdivision_1_iso_code=#{state} ")
    List<IRegion> findCity(@Param("country")String country,@Param("state")String state);
}

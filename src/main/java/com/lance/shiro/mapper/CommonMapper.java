package com.lance.shiro.mapper;

import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IRegion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Select("select distinct  country_iso_code,country_name from i_region ")
    List<IRegion> findCountry();

    @Select("select distinct subdivision_1_iso_code, subdivision_1_name from i_region where country_iso_code='AU' and subdivision_1_iso_code is not null order by subdivision_1_iso_code asc")
    List<IRegion> findState(String country);

    @Select("select distinct city_name from i_region where country_iso_code=#{country} and city_name is not null and subdivision_1_iso_code=#{state} ")
    List<IRegion> findCity(@Param("country") String country, @Param("state") String state);

    //增加用户
    @Insert("insert into i_attachment(filePath,fileName,extension,fileSize,belongToID,belongToCategory,description,contentType,createUser,createTime,module) " +
            "values(#{filePath},#{fileName},#{extension},#{fileSize},#{belongToID},#{belongToCategory},#{description},#{contentType},#{createUser},now(),#{module})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int addAttachment(IAttachment attachment);


}

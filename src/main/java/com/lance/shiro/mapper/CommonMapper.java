package com.lance.shiro.mapper;

import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IRegion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Select("select distinct  country_name from i_region ")
    List<String> findCountry();

    @Select("select distinct subdivision_1_name from i_region where country_name=#{country} and subdivision_1_name is not null order by subdivision_1_name asc")
    List<String> findState(@Param("country") String country);

    @Select("select distinct city_name from i_region where country_name=#{country} and subdivision_1_name=#{state} and city_name is not null ")
    List<String> findCity(@Param("country") String country, @Param("state") String state);

    //插入附件
    @Insert("insert into i_attachment(filePath,fileName,extension,fileSize,belongToID,belongToCategory,description,contentType,createUser,createTime,module,realPath,status,originalFilename) " +
            "values(#{filePath},#{fileName},#{extension},#{fileSize},#{belongToID},#{belongToCategory},#{description},#{contentType},#{createUser},now(),#{module},#{realPath},#{status},#{originalFilename})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int addAttachment(IAttachment attachment);

    @Select("select * from i_attachment where status = '0' ")
    List<IAttachment> findAllAttachment();

    @Select("SELECT * FROM i_attachment where status = '0' and  id in (${ids}) ")
    List<IAttachment> findListAttachmentByIds(@Param("ids") String ids);

    @Select("SELECT * FROM i_attachment where status = '0' and  module like CONCAT('%',#{module},'%') ")
    List<IAttachment> findListAttachmentByModule(String module);

    @Update("DELETE FROM i_attachment where id=#{id}")
    int deleteAttachment(int id);

    @Update("update i_attachment set filePath=#{filePath},fileName=#{fileName},extension=#{extension},fileSize=#{fileSize},description=#{description},contentType=#{contentType},createUser=#{createUser},realPath=#{realPath},originalFilename=#{originalFilename}  where id=#{id}")
    int updateAttachment(IAttachment attachment);

    @Select("select * from i_attachment where status = '0' and belongToID=#{belongToID} and belongToCategory=#{belongToCategory}")
    List<IAttachment> findListAttachmentByBelong(@Param("belongToID") String belongToID, @Param("belongToCategory") String belongToCategory);

}

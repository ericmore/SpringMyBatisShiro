package com.lance.shiro.mapper;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper
public interface PropertyListMapper {
    @Insert("insert into i_property_list (buildingName,buildingAddress,city,state,country,x,y,buildingOverview,features,date,createTime,updateTime,status) values(#{buildingName},#{buildingAddress},#{city},#{state},#{country},#{x},#{y},#{buildingOverview},#{features},#{date},now(),now(),'active')")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public int add(IPropertyList propertyList);

    @Update("update i_property_list set buildingName = #{buildingName},buildingAddress = #{buildingAddress},city = #{city},state = #{state},country = #{country},x = #{x},y = #{y},buildingOverview = #{buildingOverview},features = #{features},date = #{date},updateTime = now() where id=#{id} ")
    int  update(IPropertyList propertyList);

    @Select("select * from i_property_list where id=#{id}")
    @Results({
            @Result(property="id",column="id"),
            @Result(property="lotTypeList",column="id",javaType=List.class,
                    many=@Many(select="com.lance.shiro.mapper.LotTypeMapper.findAllLotTypeByPropertyList"))
    })
    public IPropertyList get(int id);

    //根据city查询
    @Select("SELECT * FROM i_property_list where status = 'active' and  city in (${citys})  ")
    @Results({
            @Result(property="id",column="id"),
            @Result(property="lotTypeList",column="id",javaType=List.class,
                    many=@Many(select="com.lance.shiro.mapper.LotTypeMapper.findAllLotTypeByPropertyList"))
    })
    ArrayList<IPropertyList> findAllByCitys(@Param("citys") String citys);

    //查询所以用户
    @Select("SELECT* FROM i_property_list where status = 'active'  ")
    @Results({
            @Result(property="id",column="id"),
            @Result(property="lotTypeList",column="id",javaType=List.class,
                    many=@Many(select="com.lance.shiro.mapper.LotTypeMapper.findAllLotTypeByPropertyList"))
    })
    ArrayList<IPropertyList> findAll();

    @Update("update i_property_list set status = 'inactive',updateTime = now()  where id=#{id} ")
    public void delete(int id);


}

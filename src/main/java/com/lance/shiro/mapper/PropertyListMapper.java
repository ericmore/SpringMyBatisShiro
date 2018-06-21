package com.lance.shiro.mapper;

import com.lance.shiro.entity.IPropertyList;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PropertyListMapper {
    @Insert("insert into i_property_list (buildingName,buildingAddress,city,state,country,x,y,buildingOverview,features,date,createTime,updateTime,status) values(#{buildingName},#{buildingAddress},#{city},#{state},#{country},#{x},#{y},#{buildingOverview},#{features},#{date},now(),now(),#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(IPropertyList propertyList);

    @Update("update i_property_list set buildingName = #{buildingName},buildingAddress = #{buildingAddress},city = #{city},state = #{state},country = #{country},x = #{x},y = #{y}," +
            "buildingOverview = #{buildingOverview},features = #{features},date = #{date},status = #{status},updateTime = now() where id=#{id} ")
    int update(IPropertyList propertyList);

//    @Update("update i_property_list set ${propertyList}  ,updateTime = now() where id=#{id} ")
//    int update(@Param("id") int id, @Param("propertyList") String propertyList);

    @Select("select * from i_property_list where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lotTypeList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lance.shiro.mapper.PropertyMapper.findAllLotType"))
    })
    public IPropertyList get(int id);

    //根据city查询
    @Select("SELECT * FROM i_property_list where  city in (${citys})  ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lotTypeList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lance.shiro.mapper.PropertyMapper.findAllLotType"))
    })
    ArrayList<IPropertyList> findAllByCitys(@Param("citys") String citys);

    //查询所有用户
    @Select("SELECT * FROM i_property_list where 1=1 ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lotTypeList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lance.shiro.mapper.PropertyMapper.findAllLotType"))
    })
    ArrayList<IPropertyList> findAll();

    @Update("delete from i_property_list where id=#{id} ")
    public void delete(int id);


    @Update("update i_property_list set ${attributes}  ,updateTime = now() where id=#{id} ")
    int updateAttribute(@Param("id") int id, @Param("attributes") String attributes);

    @Select("SELECT * FROM i_property_list where ${attributes}  ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lotTypeList", column = "id", javaType = List.class,
                    many = @Many(select = "com.lance.shiro.mapper.PropertyMapper.findAllLotType"))
    })
    ArrayList<IPropertyList> findAllByAttr(@Param("attributes") String attributes);

}

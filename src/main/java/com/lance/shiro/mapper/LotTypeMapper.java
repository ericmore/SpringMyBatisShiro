package com.lance.shiro.mapper;

import com.lance.shiro.entity.ILotType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LotTypeMapper {
    @Insert("insert into i_lot_type (bedroomCount,bathRoomCount,parkingCount,price,qty,notes,propertyListId,createTime,updateTime,status) values(#{bedroomCount},#{bathRoomCount},#{parkingCount},#{price},#{qty},#{notes},#{propertyListId},now(),now(),'active')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void add(ILotType lotType);

    @Update("update i_lot_type set bedroomCount=#{bedroomCount},bathRoomCount=#{bathRoomCount},parkingCount=#{parkingCount},price=#{price},qty=#{qty},notes=#{notes},propertyListId=#{propertyListId},updateTime = now(),status = 'active' where id=#{id}")
    int update(ILotType lotType);

    @Select("select * from i_lot_type where id=#{id}")
    public ILotType get(int id);

    @Select("select * from i_lot_type where propertyListId=#{propertyListId} and status = 'active'")
//    @Results({
//             @Result(property="id",column="id"),
//            @Result(property="propertyList",column="propertyListId",javaType=IPropertyList.class,
//                    one=@One(select="com.lance.shiro.mapper.PropertyListMapper.get"))
//    })
    public List<ILotType> findAllLotTypeByPropertyList(int propertyListId);

    @Delete("delete from i_lot_type where id=#{id}")
    public void delete(int id);

    @Delete("delete from i_lot_type where propertyListId=#{propertyListId}")
    public void deleteByPropertyList(int propertyListId);
}

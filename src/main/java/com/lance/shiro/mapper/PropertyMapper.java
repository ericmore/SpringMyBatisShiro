package com.lance.shiro.mapper;

import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface PropertyMapper {
    @Insert("insert into i_property (bedroomCount,bathRoomCount,parkingCount,price,notes,address,agentId,propertyListId,lot,buildingOverview,features,purchasePrice,sellingPrice,weeklyRent,managedDoma,type,textContractOfSale,textDepositForm,textSolicitor,textBillsCharges,textManagementAgreement,textOthers,purchaseDate,commenceDate,commission_rent,commission_sale,term_of_lease,ownerId,createTime,updateTime,status) values(#{bedroomCount},#{bathRoomCount},#{parkingCount},#{price},#{notes},#{address},#{agentId},#{propertyListId},#{lot},#{buildingOverview},#{features},#{purchasePrice},#{sellingPrice},#{weeklyRent},#{managedDoma},#{type},#{textContractOfSale},#{textDepositForm},#{textSolicitor},#{textBillsCharges},#{textManagementAgreement},#{textOthers},#{purchaseDate},#{commenceDate},#{commission_rent},#{commission_sale},#{term_of_lease},#{ownerId},now(),now(),#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(IProperty property);

    @Update("update i_property set address = #{address},agentId = #{agentId},propertyListId = #{propertyListId},lot = #{lot},buildingOverview = #{buildingOverview},features = #{features},purchasePrice = #{purchasePrice}" +
            ",sellingPrice = #{sellingPrice},weeklyRent = #{weeklyRent},managedDoma = #{managedDoma},type = #{type},textContractOfSale = #{textContractOfSale},textDepositForm = #{textDepositForm}," +
            "textSolicitor = #{textSolicitor},textBillsCharges = #{textBillsCharges},textManagementAgreement = #{textManagementAgreement},textOthers = #{textOthers},purchaseDate = #{purchaseDate}," +
            "commenceDate = #{commenceDate},commission_rent = #{commission_rent},commission_sale = #{commission_sale},term_of_lease = #{term_of_lease},ownerId = #{ownerId},bedroomCount= #{bedroomCount}," +
            "bathRoomCount=#{bathRoomCount},parkingCount=#{parkingCount},price=#{price},notes=#{notes},status=#{status},sale_status=#{sale_status},updateTime = now() where id=#{id} ")
    int update(IProperty property);

//    @Update("update i_property set ${propertyAttr} ,updateTime = now() where id=#{id} ")
//    int update(@Param("id") int id, @Param("propertyAttr") String propertyAttr);


    @Update("delete from i_property where id=#{id} ")
    public void delete(int id);

    @Select("select * from i_property where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "agentId", column = "agentId"),
            @Result(property = "ownerId", column = "ownerId"),
            @Result(property = "propertyListId", column = "propertyListId"),
            @Result(property = "agent", column = "agentId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
    })
    public IProperty get(int id);

    //根据PropertyList查询
//    @Select("SELECT * FROM i_property where  propertyListId in (${propertyListId})  ")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "agent", column = "agentId", javaType = IUser.class,
//                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
//            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
//                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
//            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
//                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
//    })
//    ArrayList<IProperty> findAllByPropertyList(@Param("propertyListId") String propertyListId);
    @Select("SELECT * FROM i_property where ${attributes} ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "agentId", column = "agentId"),
            @Result(property = "ownerId", column = "ownerId"),
            @Result(property = "propertyListId", column = "propertyListId"),
            @Result(property = "agent", column = "agentId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
    })
    ArrayList<IProperty> findAllByPropertyList(@Param("attributes") String attributes);

    //根据Agent查询
    @Select("SELECT * FROM i_property where  agentId in (${agentId})  ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "agentId", column = "agentId"),
            @Result(property = "ownerId", column = "ownerId"),
            @Result(property = "propertyListId", column = "propertyListId"),
            @Result(property = "agent", column = "agentId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
    })
    ArrayList<IProperty> findAllByAgent(@Param("agentId") String agentId);

    //根据Owner查询
    @Select("SELECT * FROM i_property where ownerId in (${ownerId})  ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "agentId", column = "agentId"),
            @Result(property = "ownerId", column = "ownerId"),
            @Result(property = "propertyListId", column = "propertyListId"),
            @Result(property = "agent", column = "agentId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
    })
    ArrayList<IProperty> findAllByOwner(@Param("ownerId") String ownerId);

    //查询
    @Select("SELECT* FROM i_property where 1=1  ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "agentId", column = "agentId"),
            @Result(property = "ownerId", column = "ownerId"),
            @Result(property = "propertyListId", column = "propertyListId"),
            @Result(property = "agent", column = "agentId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
            @Result(property = "propertyList", column = "propertyListId", javaType = IPropertyList.class,
                    one = @One(select = "com.lance.shiro.mapper.PropertyListMapper.get")),
            @Result(property = "owner", column = "ownerId", javaType = IUser.class,
                    one = @One(select = "com.lance.shiro.mapper.UserMapper.get")),
    })
    ArrayList<IProperty> findAll();


    @Update("update i_property set ${attributes}  ,updateTime = now() where id=#{id} ")
    int updateAttribute(@Param("id") int id, @Param("attributes") String attributes);


    @Select("SELECT bedroomCount,bathRoomCount,parkingCount,price,group_concat(distinct notes SEPARATOR '\\r\\n') notes,count(1) qty FROM i_property where propertyListId = #{propertyListId} " +
            " group by bedroomCount,bathRoomCount,parkingCount,price,propertyListId ")
    ArrayList<HashMap<String,Object>> findAllLotType(int propertyListId);
}

package com.lance.shiro.mapper;

import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //增加用户
    @Insert(" insert into i_user(personalID,username,password,firstName,middleName,lastName,role,code,referID,email,privateEmail,sex,age,mobile,country,state,city,street,position,company,experience,createTime,updateTime,status) " +
            "values(#{personalID},#{username},Md5(#{password}),#{firstName},#{middleName},#{lastName},#{role},#{code},#{referID},#{email},#{privateEmail},#{sex},#{age},#{mobile},#{country},#{state},#{city},#{street},#{position},#{company},#{experience},now(),now(),#{status})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int add(IUser user);

    //更新
    @Update("update i_user set personalID=#{personalID},username=#{username},password=#{password},firstName=#{firstName},middleName=#{middleName},lastName=#{lastName},role=#{role},code=#{code},referID=#{referID},email=#{email},privateEmail=#{privateEmail},sex=#{sex},age=#{age},mobile=#{mobile},country=#{country},state=#{state},city=#{city},street=#{street},position=#{position},company=#{company},experience=#{experience},updateTime=now(),status=#{status} where id=#{id}")
    int update(IUser user);

    @Update("update i_user set ${attributes}  ,updateTime = now() where id=#{id} ")
    int updateAttribute(@Param("id") int id, @Param("attributes") String attributes);

    //删除用户
    @Update("<script>"
            + "update i_user set status='inactive',updateTime = now() where status !='inactive' and id IN "
            + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    int deleteAllByIds(@Param("ids") List<Integer> ids);

    //查询所有用户
    @Select("SELECT* FROM i_user  where status !='inactive' ")
    ArrayList<IUser> findAll();

    //根据role查询
    @Select("SELECT* FROM i_user where status != 'inactive' and  role in (${roles})  ")
    ArrayList<IUser> findAllByRoles(@Param("roles") String roles);

    //获取
    @Select("select * from i_user where id = #{id} ")
    IUser get(@Param("id") int id);

    @Select("SELECT * FROM i_user where status !='inactive' and ${attributes}")
    ArrayList<IUser> findAllByAttr(@Param("attributes") String attributes);

    @Select("SELECT * FROM i_user where 1=1 and ${attributes} limit 1")
    IUser findByAttrAndStatus(@Param("attributes") String attributes);

    @Select("SELECT max(code) code FROM i_user where 1=1 and ${attributes} ")
    Map findMaxCode(@Param("attributes") String attributes);

    @Select("select id, firstName,lastName,code from i_user u where u.role = 'agent' and u.referID = #{referid} ")
    List<IUser> findAgentByReferId(String referid);

    @Select("select concat(firstName,' ',lastName) as name,code from i_user u where u.role = 'agent' and u.referID = #{referid} ")
    List<Map<String, String>> findAgent(String referid);
}

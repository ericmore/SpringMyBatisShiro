package com.lance.shiro.mapper;
import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {
    //根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
    @Select("select * from i_user where username=#{username} and password=#{password} and status != 'deleted' limit 1")
    IUser findByUserNameAndPassword(@Param("username")String username,@Param("password")String password);
    //增加用户
    @Insert(" insert into i_user(personalID,username,password,firstName,middleName,lastName,role,code,referID,email,sex,age,mobile,country,state,city,street,position,company,experience,createTime,updateTime,status) " +
            "values(#{personalID},#{username},Md5(#{password}),#{firstName},#{middleName},#{lastName},#{role},#{code},#{referID},#{email},#{sex},#{age},#{mobile},#{country},#{state},#{city},#{street},#{position},#{company},#{experience},now(),now(),#{status})")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int addUser(IUser user);

    //根据用户名查询
    @Select("select * from i_user where username=#{username} and status != 'deleted' limit 1")
    IUser findByUserName(String username);

    //根据role查询
    @Select("SELECT* FROM i_user where status = 'active' and  role in (${roles})  ")
    ArrayList<IUser> findAllByRoles(@Param("roles") String roles);

    //查询所以用户
    @Select("SELECT* FROM i_user where status = 'active'  ")
    ArrayList<IUser> findAll();


    //删除用户
    @Update("<script>"
            + "update i_user set status='deleted',updateTime = now() where status !='deleted' and id IN "
            + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    int  deleteAllByIds(@Param("ids")  List<String> ids);

    //更新
    @Update("update i_user set personalID=#{personalID},username=#{username},password=#{password},firstName=#{firstName},middleName=#{middleName},lastName=#{lastName},role=#{role},code=#{code},referID=#{referID},email=#{email},sex=#{sex},age=#{age},mobile=#{mobile},country=#{country},state=#{state},city=#{city},street=#{street},position=#{position},company=#{company},experience=#{experience},updateTime=now(),status=#{status} where id=#{id}")
    int  update(IUser user);

    //获取
    @Select("select * from i_user where id = #{id} ")
    IUser get(@Param("id") int id);

}

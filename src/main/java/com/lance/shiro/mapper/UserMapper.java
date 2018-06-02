package com.lance.shiro.mapper;
import com.lance.shiro.entity.IUser;
import org.apache.ibatis.annotations.*;

import java.util.Set;

@Mapper
public interface UserMapper {
    //根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
    @Select("select * from i_user where username=#{username} and password=#{password}")
    IUser findByUserNameAndPassword(@Param("username")String username,@Param("password")String password);
    //增加用户
    @Insert(" insert into i_user(personalID,username,password,firstName,middleName,lastName,role,code,referID,email,sex,age,mobile,country,state,city,street,position,company,experience,createTime,updateTime) " +
            "values(#{personalID},#{username},Md5(#{password}),#{firstName},#{middleName},#{lastName},#{role},#{code},#{referID},#{email},#{sex},#{age},#{mobile},#{country},#{state},#{city},#{street},#{position},#{company},#{experience},#{createTime},#{updateTime})")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int addUser(IUser user);

    //根据用户名查询
    @Select("select * from i_user where username=#{username}")
    IUser findByUserName(String username);

}

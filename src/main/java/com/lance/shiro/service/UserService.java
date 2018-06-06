package com.lance.shiro.service;

import com.lance.shiro.entity.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    // 通过用户名及密码核查用户登录
    Map login(String username, String password);

    //增加用户
    Map register(IUser user);

    //根据用户名查询
    Map findByUserName(String user);

    IUser ckeckByUserName(String username);

    /**
     * 获取资源集合
     *
     * @param account
     * @return
     */
    Set<String> findPermissions(String account);

    /**
     * 通过role获取用户列表
     * @param role
     * @return
     */
    ArrayList<Map> findAllByRoles(List<String> role);

    /**
     * 删除用户
     * @param id
     */
    int deleteAllByIds(ArrayList<String> id);

    /**
     * 修改用户
     * @param user
     */
    Map update(IUser user);

}

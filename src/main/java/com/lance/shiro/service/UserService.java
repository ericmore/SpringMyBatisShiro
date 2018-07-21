package com.lance.shiro.service;

import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {


    Map get(int id);

    Map findByCode(String code);

    IUser ckeckByCode(String code);

    Set<String> findPermissions(String account);

    ArrayList<Map> findAllByRoles(List<String> role);

    IUser findExternalByCode(String code);

    ArrayList<Map> findAllByAttr(Map<String, String> reqMap);

    void deleteAllByIds(ArrayList<Integer> id);

    Map save(IUser user) throws Exception;

    Map update(IUser user) throws Exception;

    Map updateAttribute(int id, Map<String, String> reqMap) throws Exception;

    Map apply(int id) throws Exception;

    Map approve(int id, String type) throws Exception;

}

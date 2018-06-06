package com.lance.shiro.service;

import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ContentService {

    //保存
    ArrayList<Map> save(ArrayList<IContent> contents);
    //保存
    Map save(IContent content);

    //查询
    ArrayList<Map> findByModule(ArrayList<String> modules);

    //查询
    Map findByModule(String module);

}

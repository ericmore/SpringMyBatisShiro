package com.lance.shiro.service;

import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ContentService {

    //保存
    IContent save(IContent content);

    //查询
    IContent findByModule(String module);

}

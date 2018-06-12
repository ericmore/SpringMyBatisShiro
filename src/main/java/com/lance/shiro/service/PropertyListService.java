package com.lance.shiro.service;

import com.lance.shiro.entity.IPropertyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PropertyListService {

    Map get(int id);

    Map save(IPropertyList propertyList) throws IllegalAccessException;

    void deleteAllByIds(ArrayList<Integer> ids);

    void delete(Integer id);

    ArrayList<Map> findAllByCitys(List<String> city);

    IPropertyList updateAttribute(int id, Map<String, String> reqMap);

    ArrayList<Map> findAllByAttr(Map<String, String> reqMap);
}

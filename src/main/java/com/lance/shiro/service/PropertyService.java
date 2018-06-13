package com.lance.shiro.service;

import com.lance.shiro.entity.IProperty;

import java.util.ArrayList;
import java.util.Map;

public interface PropertyService {

    Map get(int id);

    Map save(IProperty propertyList) throws IllegalAccessException;

    void deleteAllByIds(ArrayList<Integer> ids);

    void delete(Integer id);

//    ArrayList<Map> findAllByPropertyLists(ArrayList<Integer> propertyListId);

    ArrayList<Map> findAllByAgents(ArrayList<Integer> agentId);

    ArrayList<Map> findAllByOwners(ArrayList<Integer> ownerId);

    ArrayList<Map> findAllByPropertyLists(Map<String, String> reqMap);

    IProperty updateAttribute(int id, Map<String, String> reqMap);
}

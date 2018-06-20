package com.lance.shiro.service;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.PropertyMapper;
import com.lance.shiro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> findAgentPropertyManagement(String user) {
        return propertyMapper.findAgentPropertyManagement(user);
    }

    @Override
    public Map<String, String> findAgentSalesyRecord(String user) {
        return propertyMapper.findAgentSalesyRecord(user);
    }

    @Override
    public List<Map<String, Object>> findAgentProperty(String referid) {
        List<IUser> userList = userMapper.findAgentByReferId(referid);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (null != userList && userList.size() > 0) {
            for (IUser iUser : userList) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", iUser.getFirstName() + " " + iUser.getLastName());
                map.put("code", iUser.getCode());
                List<Map<String, String>> propertyList = propertyMapper.findAllSaleByAgent(iUser.getId());
                map.put("saledProperties", propertyList);
                Map<String, String> map1 = propertyMapper.findAgentSalesTotalCommission(iUser.getId());
                map.put("saledComission", map1);
                mapList.add(map);
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, String>> findAllAgentByReferId(String referid) {
        List<Map<String, String>> mapList = userMapper.findAgent(referid);
        return mapList;
    }
}
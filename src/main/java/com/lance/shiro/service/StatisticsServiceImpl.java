package com.lance.shiro.service;

import com.lance.shiro.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public Map<String, String> findAgentPropertyManagement(String user) {
        return propertyMapper.findAgentPropertyManagement(user);
    }

    @Override
    public Map<String, String> findAgentSalesyRecord(String user) {
        return propertyMapper.findAgentSalesyRecord(user);
    }
}
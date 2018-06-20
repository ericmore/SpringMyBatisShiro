package com.lance.shiro.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {

    Map<String, String> findAgentPropertyManagement(String user);

    Map<String, String> findAgentSalesyRecord(String user);

    List<Map<String,Object>> findAgentProperty(String referid);

    List<Map<String,String>> findAllAgentByReferId(String referid);
}

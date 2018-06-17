package com.lance.shiro.service;

import java.util.Map;

public interface StatisticsService {

    Map<String, String> findAgentPropertyManagement(String user);

    Map<String, String> findAgentSalesyRecord(String user);
}

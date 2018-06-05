package com.lance.shiro.service;

import com.lance.shiro.entity.IRegion;
import com.lance.shiro.mapper.CommonMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CommonServiceImpl implements CommonService {
    public Logger log = LogManager.getLogger(getClass());
    @Autowired
    private CommonMapper commonMapper;

    @Override
    public List<Map<String, String>> findCountry() {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findCountry();
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCountry_iso_code());
                map.put("name", iRegion.getCountry_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return mapList;
    }

    @Override
    public List<Map<String, String>> findState(String country) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findState(country);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getSubdivision_1_iso_code());
                map.put("name", iRegion.getSubdivision_1_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return mapList;
    }

    @Override
    public List<Map<String, String>> findCity(String country, String state) {

        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findCity(country, state);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCity_name());
                map.put("name", iRegion.getCity_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return mapList;

    }
}
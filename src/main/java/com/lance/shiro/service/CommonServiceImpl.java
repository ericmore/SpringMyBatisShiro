package com.lance.shiro.service;

import com.lance.shiro.entity.IRegion;
import com.lance.shiro.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public List<IRegion> findCountry() {
        return commonMapper.findCountry();
    }

    @Override
    public List<IRegion> findState(String country) {
        return commonMapper.findState(country);
    }

    @Override
    public List<IRegion> findCity(String country, String state) {
        return commonMapper.findCity(country, state);
    }
}
package com.lance.shiro.service;

import com.lance.shiro.entity.IRegion;

import java.util.List;

public interface CommonService {
    /**
     * find country
     *
     * @return
     */
    List<IRegion> findCountry();

    /**
     * find state
     *
     * @param country
     * @return
     */
    List<IRegion> findState(String country);

    /**
     * find city
     * @param country
     * @param state
     * @return
     */
    List<IRegion> findCity(String country, String state);
}

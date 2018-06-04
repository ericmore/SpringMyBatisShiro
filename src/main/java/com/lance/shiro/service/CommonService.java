package com.lance.shiro.service;

import java.util.List;
import java.util.Map;

public interface CommonService {

    /**
     * find country
     *
     * @return
     */
    List<Map<String, String>> findCountry();

    /**
     * find state
     *
     * @param country
     * @return
     */
    List<Map<String, String>> findState(String country);

    /**
     * find city
     * @param country
     * @param state
     * @return
     */
    List<Map<String, String>> findCity(String country, String state);
}

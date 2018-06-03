package com.lance.shiro.web;


import com.lance.shiro.entity.IRegion;
import com.lance.shiro.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/common/")
public class CommonController extends BaseController {

    @Autowired
    private CommonService commonService;

    /**
     * find country
     *
     * @return
     */
    @RequestMapping(value = "country", method = RequestMethod.GET)
    public ResponseEntity country() {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonService.findCountry();
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCode());
                map.put("name", iRegion.getName());
                mapList.add(map);
            }
        } catch (Exception e) {

        }
        return ResponseEntity.ok(mapList);
    }

    /**
     * find state
     *
     * @return
     */
    @RequestMapping(value = "state", method = RequestMethod.GET)
    public ResponseEntity state(@RequestParam("country") String country) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonService.findState(country);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCode());
                map.put("name", iRegion.getName());
                mapList.add(map);
            }
        } catch (Exception e) {

        }
        return ResponseEntity.ok(mapList);
    }


    /**
     * find city
     *
     * @return
     */
    @RequestMapping(value = "city", method = RequestMethod.GET)
    public ResponseEntity city(@RequestParam("country") String country, @RequestParam("state") String state) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonService.findCity(country, state);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCode());
                map.put("name", iRegion.getName());
                mapList.add(map);
            }
        } catch (Exception e) {

        }
        return ResponseEntity.ok(mapList);
    }

}




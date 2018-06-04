package com.lance.shiro.web;


import com.lance.shiro.entity.IRegion;
import com.lance.shiro.service.CommonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        return ResponseEntity.ok(commonService.findCountry());
    }

    /**
     * find state
     *
     * @return
     */
    @RequestMapping(value = "state", method = RequestMethod.GET)
    public ResponseEntity state(@RequestParam("country") String country) {
        return ResponseEntity.ok(commonService.findState(country));
    }


    /**
     * find city
     *
     * @return
     */
    @RequestMapping(value = "city", method = RequestMethod.GET)
    public ResponseEntity city(@RequestParam("country") String country, @RequestParam("state") String state) {
        return ResponseEntity.ok(commonService.findCity(country,state));
    }

}




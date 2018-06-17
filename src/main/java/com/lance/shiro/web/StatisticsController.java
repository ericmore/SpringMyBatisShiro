package com.lance.shiro.web;

import com.lance.shiro.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/statistics/")
public class StatisticsController extends BaseController {

    @Autowired
    StatisticsService statisticsService;

    /**
     * agent property management
     *
     * @return
     */
    @RequestMapping(value = "agent-property-management", method = RequestMethod.GET)
    public ResponseEntity agentPropertyManagement(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(statisticsService.findAgentPropertyManagement(user));
        } catch (Exception e) {
            return error("FindAgentPropertyManagement Error,Pls Contact Administrators!");
        }
    }

    /**
     * agent sales record
     *
     * @return
     */
    @RequestMapping(value = "agent-sales-record", method = RequestMethod.GET)
    public ResponseEntity agentSalesyRecord(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(statisticsService.findAgentSalesyRecord(user));
        } catch (Exception e) {
            return error("findAgentSalesyRecord Error,Pls Contact Administrators!");
        }
    }

}

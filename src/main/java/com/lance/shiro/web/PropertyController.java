package com.lance.shiro.web;

import com.lance.shiro.entity.IProperty;
import com.lance.shiro.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by bingyun on 2018-06-08.
 */
@RestController
@RequestMapping("/rest/property")
public class PropertyController extends BaseController {

    //注入PropertyService
    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") int id) {
        Map obj = propertyService.get(id);
        return success("Operation success!", obj);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody IProperty property) {
        Map obj = propertyService.save(property);
        return success("Operation success!", obj);
    }

    /**
     * delete
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<Integer> id) {
        propertyService.deleteAllByIds(id);
        return success("Operation success!");
    }

//    @RequestMapping(value = "propertyList", method = RequestMethod.GET)
//    public ResponseEntity findAllByPropertyList(@RequestParam(name = "id", required = false) ArrayList<Integer> id) {
//        ArrayList<Map> list = propertyService.findAllByPropertyLists(id);
//        return success("Operation success!", list);
//    }

    @RequestMapping(value = "propertyList", method = RequestMethod.GET)
    public ResponseEntity findAllByPropertyList(@RequestParam Map<String, String> reqMap) {
        try {
            ArrayList<Map> list = propertyService.findAllByPropertyLists(reqMap);
            return success("Operation success!", list);
        } catch (Exception e) {
            return error("GET PropertyList Exception,Pls Contact Administrators!");
        }
    }


    @RequestMapping(value = "agent", method = RequestMethod.GET)
    public ResponseEntity findAllByAgent(@RequestParam(name = "id", required = false) ArrayList<Integer> id) {
        ArrayList<Map> list = propertyService.findAllByAgents(id);
        return success("Operation success!", list);
    }

    @RequestMapping(value = "owner", method = RequestMethod.GET)
    public ResponseEntity findAllByOwner(@RequestParam(name = "id", required = false) ArrayList<Integer> id) {
        ArrayList<Map> list = propertyService.findAllByOwners(id);
        return success("Operation success!", list);
    }

    /**
     * update Attribute
     *
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity put(@PathVariable("id") int id, @RequestParam Map<String, String> reqMap) {
        try {
            if (null != reqMap) {
                IProperty iProperty = propertyService.updateAttribute(id, reqMap);
                return success("Operation success!", iProperty);
            } else {
                return success("Operation success!", null);
            }
        } catch (Exception e) {
            return error("update Attribute Exception,Pls Contact Administrators!");
        }
    }

}

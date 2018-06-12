package com.lance.shiro.web;

import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.service.PropertyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by bingyun on 2018-06-08.
 */
@RestController
@RequestMapping("/rest/propertyList")
public class PropertyListController extends BaseController {

    //注入PropertyListService
    @Autowired
    private PropertyListService propertyListService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") int id) {
        Map obj = propertyListService.get(id);
        return success("Operation success!", obj);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody IPropertyList propertyList) {
        try {
            Map obj = propertyListService.save(propertyList);
            return success("Operation success!", obj);
        } catch (Exception e) {
            return error("Add PropertyList Exception,Pls Contact Administrators!");
        }
    }

    /**
     * delete
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<Integer> id) {
        propertyListService.deleteAllByIds(id);
        return success("Operation success!");
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ResponseEntity query(@RequestParam(name = "city", required = false) ArrayList<String> city) {
//        ArrayList<Map> list = propertyListService.findAllByCitys(city);
//        return success("Operation success!", list);
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity query(@RequestParam Map<String, String> reqMap) {
        try {
            ArrayList<Map> list = propertyListService.findAllByAttr(reqMap);
            return success("Operation success!", list);
        } catch (Exception e) {
            return error("GET PropertyList Exception,Pls Contact Administrators!");
        }
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
                IPropertyList iPropertyList = propertyListService.updateAttribute(id, reqMap);
                return success("Operation success!", iPropertyList);
            } else {
                return success("Operation success!", null);
            }
        } catch (Exception e) {
            return error("update Attribute Exception,Pls Contact Administrators!");
        }
    }
}

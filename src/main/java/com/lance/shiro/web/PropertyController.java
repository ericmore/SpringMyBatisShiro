package com.lance.shiro.web;

import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.PropertyListService;
import com.lance.shiro.service.PropertyService;
import com.lance.shiro.service.UserService;
import com.lance.shiro.utils.UserStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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
     *delete
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<Integer> id) {
        propertyService.deleteAllByIds(id);
        return success("Operation success!");
    }

    @RequestMapping(value = "propertyList", method = RequestMethod.GET)
    public ResponseEntity findAllByPropertyList( @RequestParam(name="id",required=false) ArrayList<Integer> id) {
        ArrayList<Map> list = propertyService.findAllByPropertyLists(id);
        return success("Operation success!", list);
    }

    @RequestMapping(value = "agent", method = RequestMethod.GET)
    public ResponseEntity findAllByAgent( @RequestParam(name="id",required=false) ArrayList<Integer> id) {
        ArrayList<Map> list = propertyService.findAllByAgents(id);
        return success("Operation success!", list);
    }

    @RequestMapping(value = "owner", method = RequestMethod.GET)
    public ResponseEntity findAllByOwner( @RequestParam(name="id",required=false) ArrayList<Integer> id) {
        ArrayList<Map> list = propertyService.findAllByOwners(id);
        return success("Operation success!", list);
    }

}

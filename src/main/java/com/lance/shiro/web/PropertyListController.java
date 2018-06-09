package com.lance.shiro.web;

import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.PropertyListService;
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
@RequestMapping("/rest/propertyList")
public class PropertyListController extends BaseController {

    //注入userService
    @Autowired
    private PropertyListService propertyListService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") int id) {
        Map obj = propertyListService.get(id);
        return success("Operation success!", obj);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody IPropertyList propertyList) {
        Map obj = propertyListService.save(propertyList);
        return success("Operation success!", obj);
    }

    /**
     *delete
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<Integer> id) {
        propertyListService.deleteAllByIds(id);
        return success("Operation success!");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity query( @RequestParam(name="city",required=false) ArrayList<String> city) {
        ArrayList<Map> list = propertyListService.findAllByCitys(city);
        return success("Operation success!", list);
    }
}

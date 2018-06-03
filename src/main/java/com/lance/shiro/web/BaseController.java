package com.lance.shiro.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by bingyun on 2018-06-02.
 */
@RestController
public class BaseController {
    public Logger log = LogManager.getLogger(getClass());

    public static ResponseEntity success(String msg) {
        return success(msg, null);
    }

    public static ResponseEntity success(String msg, Object data) {
        return result(true, msg, data);
    }

    public static ResponseEntity error(String msg) {
        return error(msg, null);
    }

    public static ResponseEntity error(String msg, Object data) {
        return result(false, msg, data);
    }

    public static ResponseEntity result(Boolean success, String msg, Object data) {
        HashMap<String, Object> re = new HashMap<>();
        re.put("success", success);
        re.put("msg", msg);
        re.put("data", data);
        return success? ResponseEntity.ok(re) :ResponseEntity.badRequest().body(re);
    }
}

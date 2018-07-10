package com.lance.shiro.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest/test/")
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${rootFilePath}")
    private String rootFilePath;

    @Value("${rootHttpPath}")
    private String rootHttpPath;

    @Value("${logging.config}")
    private String logging;

    @RequestMapping(value = "env", method = RequestMethod.GET)
    public ResponseEntity getEnv(){
        Map<String, Object> env = new HashMap<>();
        env.put("spring.datasource.url", url);
        env.put("rootFilePath", rootFilePath);
        env.put("rootHttpPath", rootHttpPath);
        env.put("logging.config", logging);
        return ResponseEntity.ok(env);
    }

}

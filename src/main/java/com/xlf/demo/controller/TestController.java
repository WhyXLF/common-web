package com.xlf.demo.controller;

import com.xlf.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: xiaoliufu
 * date:   2016/11/12.
 * description: 测试controller
 */
@Controller
@RequestMapping("test")
public class TestController {
    private static final Logger logger= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    @ResponseBody
    @RequestMapping("/echo/{name}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public String echo(@PathVariable(value = "name") String name){
        String echoStr="hello "+name;
        logger.info("TestController->echo :{}",echoStr);
        testService.test();
        return echoStr;
    }
}

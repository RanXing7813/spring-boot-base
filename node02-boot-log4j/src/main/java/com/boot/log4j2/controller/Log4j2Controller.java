package com.boot.log4j2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.log4j2.service.EmailService;
@RestController
public class Log4j2Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Controller.class);
    
    @Autowired
    EmailService emailService; 
    
    /**
     * 日志级别
     * OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL
     */
    @RequestMapping("/printLog")
    public String printLog (){
        LOGGER.error("ERROR 级别日志");
        LOGGER.warn("WARN 级别日志");
        LOGGER.info("INFO 级别日志");
        LOGGER.debug("DEBUG 级别日志");
        LOGGER.trace("TRACE 级别日志");
        
        emailService.send();
        
        return "success" ;
    }
}

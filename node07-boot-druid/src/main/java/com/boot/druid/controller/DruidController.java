package com.boot.druid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DruidController {
    private static final Logger LOG = LoggerFactory.getLogger(DruidController.class);

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate ;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate ;

    @RequestMapping("/druidData")
    public String druidData (){
        String sql = "SELECT COUNT(1) FROM d_phone" ;
        Integer countOne = primaryJdbcTemplate.queryForObject(sql,Integer.class) ;
        // countOne==2
        LOG.info("countOne=="+countOne);
        sql = "SELECT COUNT(1) FROM sys_user" ;
        Integer countTwo = secondaryJdbcTemplate.queryForObject(sql,Integer.class) ;
        // countOne==2
        LOG.info("countOne=="+countTwo);
        return "success" ;
    }
}

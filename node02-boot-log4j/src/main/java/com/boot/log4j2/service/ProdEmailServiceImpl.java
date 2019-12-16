package com.boot.log4j2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod") //生产环境的时候.
public class ProdEmailServiceImpl implements EmailService {

	static Logger log = LoggerFactory.getLogger(ProdEmailServiceImpl.class);
	
	@Override
	public void send() {
		log.debug("我是prod");
		
	}

}

package com.boot.log4j2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") //开发环境的时候.
public class DevEmailServiceImpl implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(DevEmailServiceImpl.class);
	 
	@Override
	public void send() {
		log.debug("我是dev");

	}

}

package com.sura.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void log() {

        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");

    }

    public void getLogger(String msg) {
        logger.info(msg);
    }
}

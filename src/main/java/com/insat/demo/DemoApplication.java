package com.insat.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        logger.info("INFO level message!!");
        logger.warn("WARN level message!!");
        logger.error("ERROR level message !!");
        logger.trace("TRACE level message..");


        SpringApplication.run(DemoApplication.class, args);
    }

}

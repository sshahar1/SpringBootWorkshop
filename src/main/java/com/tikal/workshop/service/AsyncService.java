package com.tikal.workshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by sigals on 09/09/2017.
 */
@Service
public class AsyncService {

    private Logger logger = LoggerFactory.getLogger(AsyncService.class);
    @Async
    public void runCounter() {
        int counter=0;
        while (true) {
            counter++;
            try {
                Thread.sleep(5000*60);
            } catch (InterruptedException e) {
                logger.error("Exception", e);
            }
        }
    }
}

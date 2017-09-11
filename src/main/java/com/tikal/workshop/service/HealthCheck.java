package com.tikal.workshop.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sigals on 09/09/2017.
 */
@Component
public class HealthCheck implements HealthIndicator{
    @Override
    public Health health() {

        String hostname;
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            hostname = "unknown";
        }

        return Health.up().withDetail("server", hostname).build();
    }
}

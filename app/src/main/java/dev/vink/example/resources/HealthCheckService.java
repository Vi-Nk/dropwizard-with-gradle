package dev.vink.example.resources;

import com.codahale.metrics.health.HealthCheck;

import dev.vink.example.data.PersonDatabase;

public class HealthCheckService extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        if (PersonDatabase.getSize() == 0) {
            return Result.unhealthy("Person database is empty , cannot operate until added");
        }
        return Result.healthy();
    }

}

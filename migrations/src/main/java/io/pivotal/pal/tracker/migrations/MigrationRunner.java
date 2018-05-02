package io.pivotal.pal.tracker.migrations;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MigrationRunner implements CommandLineRunner {
    private final Flyway flyway;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MigrationRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(String... args) {
        logger.info("Starting migration at " + new SimpleDateFormat().format(new Date()));

        flyway.migrate();

        logger.info("Migration completed at " + new SimpleDateFormat().format(new Date()));
    }
}

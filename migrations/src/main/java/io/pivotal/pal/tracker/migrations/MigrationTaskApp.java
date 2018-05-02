package io.pivotal.pal.tracker.migrations;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import static org.flywaydb.core.api.MigrationVersion.fromVersion;

@SpringBootApplication
@EnableTask
public class MigrationTaskApp {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();

        flyway.setBaselineOnMigrate(true);
        flyway.setBaselineVersion(fromVersion("0"));
        flyway.setOutOfOrder(false);
        flyway.setDataSource(dataSource);

        return flyway;
    }

    public static void main(String[] args) {
        SpringApplication.run(MigrationTaskApp.class, args);
    }
}

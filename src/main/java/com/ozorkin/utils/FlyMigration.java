package com.ozorkin.utils;

import org.flywaydb.core.Flyway;

public class FlyMigration {
    public static void migrateDB() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/myData", "postgres", "123243")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}

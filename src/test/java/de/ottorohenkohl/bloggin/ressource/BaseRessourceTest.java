package de.ottorohenkohl.bloggin.ressource;

import io.restassured.RestAssured;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class BaseRessourceTest {
    
    private static final Supplier<String> DISABLE_CONSTRAINTS = () -> "SET session_replication_role = 'replica'";
    private static final Supplier<String> ENABLE_CONSTRAINTS = () -> "SET session_replication_role = 'origin'";
    private static final Supplier<String> GET_TABLES = () -> "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
    private static final Function<Object, String> TRUNCATE_TABLE = tableName -> String.format(
            "TRUNCATE TABLE %s CASCADE",
            tableName);
    
    @Inject
    protected EntityManager entityManager;
    
    @BeforeEach
    @Transactional
    void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        
        for (var tableName : entityManager.createNativeQuery(GET_TABLES.get()).getResultList()) {
            entityManager.createNativeQuery(DISABLE_CONSTRAINTS.get()).executeUpdate();
            entityManager.createNativeQuery(TRUNCATE_TABLE.apply(tableName)).executeUpdate();
            entityManager.createNativeQuery(ENABLE_CONSTRAINTS.get()).executeUpdate();
        }
    }
}
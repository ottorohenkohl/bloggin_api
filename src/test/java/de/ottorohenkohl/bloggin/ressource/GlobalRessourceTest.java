package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshConfig;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;
import de.ottorohenkohl.bloggin.runtime.ConfigGenerator;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class GlobalRessourceTest extends BaseRessourceTest {
    
    @Inject
    protected ConfigGenerator configGenerator;
    
    @AfterEach
    protected void cleanup() {
        configGenerator.reset();
    }
    
    @BeforeEach
    @Transactional
    protected void setup() {
        super.setup();
        
        configGenerator.generate();
    }
    
    @Test
    @TestTransaction
    void getExistingConfigIfPresent() {
        given().when()
               .get("/global/config")
               .then()
               .statusCode(200)
               .body("identifier", equalTo(configGenerator.single().getIdentifier().value()))
               .body("favicon.identifier", equalTo(configGenerator.single().getFavicon().getIdentifier().value()));
    }
    
    @Test
    @TestTransaction
    void putFreshConfigIfValid() {
        var file = new ReferIndividual(configGenerator.single().getFavicon().getIdentifier().value());
        var page = new ReferIndividual(configGenerator.single().getHome().getIdentifier().value());
        var config = new FreshConfig(file, page);
        
        given().when()
               .contentType(ContentType.JSON)
               .body(config)
               .put("/global/config")
               .then()
               .statusCode(201)
               .header("location", String.format("%s:%d/global/config", baseURI, port));
    }
}
package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshHeader;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ComponentRessourceTest extends BaseRessourceTest {
    
    @Test
    @TestTransaction
    void postFreshHeader() {
        var header = new FreshHeader(null, "DEFAULT", "Some text", "Header");
        
        given().when()
               .body(header)
               .contentType(ContentType.JSON)
               .log()
               .body()
               .post("/component/")
               .then()
               .statusCode(201);
    }
}
package de.dracoon.services;

import static io.restassured.RestAssured.given;

import de.dracoon.config.RestAssuredConfig;
import de.dracoon.model.Token;
import de.dracoon.model.UserCredentials;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

/**
 * @author priyatham.bolli
 */
public final class AuthenticationRestService {

    private AuthenticationRestService() {
    }

    @Step("Authenticates user and provides an authentication token 'X-Sds-Auth-Token' that is required for the most operations.")
    public static Token authenticateUser(UserCredentials userCredentials, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .body(userCredentials)
                .post("v4/auth/login")
                .then()
                .spec(responseSpecification)
                .extract().as(Token.class);
    }

    @Step("Authenticates user and provides an authentication token 'X-Sds-Auth-Token' that is required for the most operations.")
    public static void authenticate(UserCredentials userCredentials, ResponseSpecification responseSpecification) {
        given()
            .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
            .contentType(ContentType.JSON)
            .when()
            .body(userCredentials)
            .post("v4/auth/login")
            .then()
            .spec(responseSpecification);
    }


}

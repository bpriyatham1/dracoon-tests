package de.dracoon.services;

import static io.restassured.RestAssured.given;

import de.dracoon.config.RestAssuredConfig;
import de.dracoon.staticdata.RestParameters;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

/**
 * @author priyatham.bolli
 */
public final class DownloadsRestService {

    private DownloadsRestService() {
    }

    @Step("Download avatar for given user ID and UUID ")
    public static byte[] downloadAvatar(Long userId, String uuid, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .contentType(ContentType.JSON)
                .when()
                .pathParam(RestParameters.USER_ID.getParameterName(), userId)
                .pathParam(RestParameters.UUID.getParameterName(), uuid)
                .get("v4/downloads/avatar/{user_id}/{uuid}")
                .then()
                .spec(responseSpecification)
                .extract().asByteArray();
    }

}

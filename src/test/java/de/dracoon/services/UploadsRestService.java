package de.dracoon.services;

import de.dracoon.config.RestAssuredConfig;
import de.dracoon.model.CompletedUploadResponse;
import de.dracoon.model.Token;
import de.dracoon.model.UploadRequestPayload;
import de.dracoon.model.UploadResponse;
import de.dracoon.staticdata.RestParameters;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

/**
 * @author priyatham.bolli
 */
public class UploadsRestService {

    public static final String AUTH_TOKEN = "X-Sds-Auth-Token";

    @Step("upload the file and extract the response")
    public static UploadResponse uploadFile(Token authToken, String token, byte[] file, String sizeInBytes, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .header("Content-Range", sizeInBytes)
                .pathParam(RestParameters.TOKEN.getParameterName(), token)
                .contentType(ContentType.BINARY)
                .header(AUTH_TOKEN, authToken.getToken())
                .when()
                .body(file)
                .post("v4/uploads/{token}")
                .then()
                .spec(responseSpecification)
                .extract().as(UploadResponse.class);
    }

    @Step("Complete the uploading of file successfully")
    public static CompletedUploadResponse completeUpload(String token, UploadRequestPayload payload, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .pathParam(RestParameters.TOKEN.getParameterName(), token)
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .put("v4/uploads/{token}")
                .then()
                .spec(responseSpecification)
                .extract().as(CompletedUploadResponse.class);
    }

}

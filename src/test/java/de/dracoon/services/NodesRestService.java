package de.dracoon.services;

import static io.restassured.RestAssured.given;
import static java.time.ZoneOffset.UTC;

import de.dracoon.config.RestAssuredConfig;
import de.dracoon.model.CopyFilePayload;
import de.dracoon.model.DataRoom;
import de.dracoon.model.DeleteNodePayLoad;
import de.dracoon.model.FolderPayload;
import de.dracoon.model.Node;
import de.dracoon.model.Token;
import de.dracoon.model.Upload;
import de.dracoon.model.UploadFilePayload;
import de.dracoon.staticdata.RestParameters;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

/**
 * @author priyatham.bolli
 */
public final class NodesRestService {

    private NodesRestService() {
    }

    public static final String AUTH_TOKEN = "X-Sds-Auth-Token";
    public static final String DATE_FORMAT = "X-Sds-Date-Format";

    @Step("Creates a new room at the provided parent node. Creation of top level rooms provided.")
    public static DataRoom createNewRoom(Node node, Token token, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .header(DATE_FORMAT, UTC)
                .header(AUTH_TOKEN, token.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(node)
                .post("v4/nodes/rooms")
                .then()
                .spec(responseSpecification)
                .extract().as(DataRoom.class);
    }

    @Step("Create new folder with Folder Payload: '{folderPayload}' ")
    public static DataRoom addFolder(FolderPayload folderPayload, Token token, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .header(DATE_FORMAT, UTC)
                .header(AUTH_TOKEN, token.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(folderPayload)
                .post("v4/nodes/folders")
                .then()
                .spec(responseSpecification)
                .extract().as(DataRoom.class);
    }

    @Step("Copies nodes to another parent ")
    public static DataRoom copyTo(CopyFilePayload copyFilePayload, Integer parentNodeId, Token token, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .pathParam(RestParameters.NODE_ID.getParameterName(), parentNodeId)
                .header(DATE_FORMAT, UTC)
                .header(AUTH_TOKEN, token.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(copyFilePayload)
                .post("v4/nodes/{node_id}/copy_to")
                .then()
                .spec(responseSpecification)
                .extract().as(DataRoom.class);
    }

    @Step("Delete by given node")
    public static void delete(Token token, DeleteNodePayLoad deleteNodePayLoad, ResponseSpecification responseSpecification) {
        given()
            .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
            .header(AUTH_TOKEN, token.getToken())
            .contentType(ContentType.JSON)
            .when()
            .body(deleteNodePayLoad)
            .delete("v4/nodes")
            .then()
            .spec(responseSpecification);
    }

    @Step("Create new file upload channel")
    public static Upload upload(Token token, UploadFilePayload uploadFilePayload, ResponseSpecification responseSpecification) {
        return
            given()
                .spec(RestAssuredConfig.getInstance().dracoonApiRequestSpec())
                .header(AUTH_TOKEN, token.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(uploadFilePayload)
                .post("v4/nodes/files/uploads")
                .then()
                .spec(responseSpecification)
                .extract().as(Upload.class);
    }

}

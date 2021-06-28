package de.dracoon.tests;

import static de.dracoon.model.ResponseSpecificationMock.SC_CREATED_JSON_NOT_NULL;
import static de.dracoon.model.ResponseSpecificationMock.SC_NO_CONTENT_NULL_VALUE;
import static de.dracoon.model.ResponseSpecificationMock.SC_OK_IMAGE_NOT_NULL;
import static de.dracoon.model.ResponseSpecificationMock.SC_OK_JSON_NOT_NULL;
import static de.dracoon.model.ResponseSpecificationMock.SC_UNAUTHORIZED_NOT_NULL;
import static de.dracoon.staticdata.TestTag.NEGATIVE;
import static de.dracoon.staticdata.TestTag.POSITIVE;
import static de.dracoon.staticdata.TestTag.REGRESSION;
import static de.dracoon.staticdata.TestTag.SMOKE;
import static de.dracoon.utils.FileUtil.extractBytes;
import static de.dracoon.utils.FileUtil.getContentLength;
import static de.dracoon.utils.FileUtil.getImage;
import static de.dracoon.utils.StringUtil.formatName;
import static org.assertj.core.api.Assertions.assertThat;

import de.dracoon.model.CompletedUploadResponse;
import de.dracoon.model.CopyFilePayload;
import de.dracoon.model.DataRoom;
import de.dracoon.model.DeleteNodePayLoad;
import de.dracoon.model.FolderPayload;
import de.dracoon.model.Item;
import de.dracoon.model.Node;
import de.dracoon.model.Token;
import de.dracoon.model.Upload;
import de.dracoon.model.UploadFilePayload;
import de.dracoon.model.UploadRequestPayload;
import de.dracoon.model.UploadResponse;
import de.dracoon.model.UserCredentials;
import de.dracoon.services.AuthenticationRestService;
import de.dracoon.services.DownloadsRestService;
import de.dracoon.services.NodesRestService;
import de.dracoon.services.UploadsRestService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.image.*;
import java.io.File;
import java.util.List;

/**
 * @author priyatham.bolli
 */
@Epic("Dracoon Rest Api Epic")
@TmsLink("JiraLink")
@ExtendWith(SoftAssertionsExtension.class)
public class DracoonApiIntegrationTests {

    private static final String PASSWORD = "CN/+7z2q2";
    private static final String USER_NAME = "priyatham.bolli@gmail.com";
    private static final String AVATAR_IMAGE_PATH = "src/test/resources/pb.png";
    private static final String FILE_TXT = "src/test/resources/test-data-file.txt";

    @Description("Authenticate successfully to Dracoon System via Authentication Rest Service")
    @DisplayName("Dracoon - API Tests -> Authenticate successfully with a valid user")
    @Tags({@Tag(REGRESSION), @Tag(SMOKE), @Tag(POSITIVE)})
    @Story("Authentication POST Endpoint User Story")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void authenticateWithValidUserTest() {
        UserCredentials userCredentials = new UserCredentials(USER_NAME, PASSWORD);
        Token token = AuthenticationRestService.authenticateUser(userCredentials, SC_OK_JSON_NOT_NULL);
        assertThat(token).as("token response").isNotNull();
    }

    @Description("Authenticate to Dracoon System via Authentication Rest Service")
    @DisplayName("Dracoon - API Tests -> Authenticate with an In-valid user")
    @Tags({@Tag(REGRESSION), @Tag(SMOKE), @Tag(NEGATIVE)})
    @Story("Authentication POST Endpoint User Story")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void authenticateWithInValidUserTest() {
        UserCredentials userCredentials = new UserCredentials("123@dracoon.de", "invalid");
        AuthenticationRestService.authenticate(userCredentials, SC_UNAUTHORIZED_NOT_NULL);
    }

    @Description("Click on New Dataroom Button via DownloadsRestService Rest Service")
    @DisplayName("Dracoon - API Tests -> Click on New Dataroom Button")
    @Story("DownloadAvatar POST Endpoint User Story")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag(SMOKE)})
    @Test
    void clickOnNewDataRoomButtonTest(SoftAssertions softly) {
        Long userId = 155392L;
        String uuid = "945979c3-2e5e-4b02-83ca-03779cd33d23";
        byte[] avatarImage = DownloadsRestService.downloadAvatar(userId, uuid, SC_OK_IMAGE_NOT_NULL);
        BufferedImage actualImage = getImage(avatarImage);
        BufferedImage expectedImage = getImage(extractBytes(AVATAR_IMAGE_PATH));
        softly.assertThat(actualImage.getHeight()).as("Height").isEqualTo(expectedImage.getHeight());
        softly.assertThat(actualImage.getWidth()).as("Width").isEqualTo(expectedImage.getWidth());
    }

    @Description("Create New DataRoom and Folder successfully via Authentication Rest Service")
    @DisplayName("Dracoon - API Tests -> Testcase 1 -> Exercise 1: Create Dataroom & Folder")
    @Story("NodesRestService CreateNewRoom, AddFolder Endpoint User Story")
    @Tags({@Tag(REGRESSION), @Tag(SMOKE)})
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void createDataRoomAndFolderTest() {
        Long adminId = 155392L;
        String roomName = "Dataroom1";
        UserCredentials userCredentials = new UserCredentials(USER_NAME, PASSWORD);
        Token token = AuthenticationRestService.authenticateUser(userCredentials, SC_OK_JSON_NOT_NULL);
        Node node = new Node(roomName, List.of(adminId));
        DataRoom room = NodesRestService.createNewRoom(node, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(room).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("room", roomName);

        FolderPayload folderPayload = new FolderPayload(room.getAuthParentId(), "folder1");
        DataRoom folder = NodesRestService.addFolder(folderPayload, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(folder).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("folder", "folder1");
    }

    @DisplayName("Dracoon - API Tests -> Testcase 2 -> Exercise 2: CRUD Operations")
    @Description("Perform CRUD operations to create,copy and delete folder")
    @Story("NodesRestService CreateNewRoom, AddFolder Endpoint User Story")
    @Tags({@Tag(REGRESSION), @Tag(SMOKE)})
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void crudOperationsTest() {
        UserCredentials userCredentials = new UserCredentials(USER_NAME, PASSWORD);
        Token token = AuthenticationRestService.authenticateUser(userCredentials, SC_OK_JSON_NOT_NULL);
        String roomName1 = "Dataroom2";
        String roomName2 = "Dataroom3";
        Long adminId = 155392L;

        //CreateNew DataRoom
        Node node1 = new Node(roomName1, List.of(adminId));
        DataRoom room1 = NodesRestService.createNewRoom(node1, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(room1).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("room", roomName1);

        //CreateNewFolder inside the Dataroom
        FolderPayload folderPayload = new FolderPayload(room1.getAuthParentId(), "folder2");
        DataRoom folder = NodesRestService.addFolder(folderPayload, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(folder).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("folder", "folder2");

        //CreateNewRoom
        Node node2 = new Node(roomName2, List.of(adminId));
        DataRoom room2 = NodesRestService.createNewRoom(node2, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(room2).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("room", roomName2);

        //CopyFolder
        List<Item> itemList = List.of(new Item(folder.getId(), folder.getName()));
        CopyFilePayload copyFilePayload = new CopyFilePayload(itemList);
        NodesRestService.copyTo(copyFilePayload, room2.getId(), token, SC_CREATED_JSON_NOT_NULL);

        //DeleteFolder
        DeleteNodePayLoad deleteNodePayLoad = new DeleteNodePayLoad(List.of(folder.getId()));
        NodesRestService.delete(token, deleteNodePayLoad, SC_NO_CONTENT_NULL_VALUE);

    }

    @DisplayName("Dracoon - API Tests -> Testcase 3 -> Exercise 3: File Upload")
    @Description("Create New DataRoom and upload a file successfully")
    @Tags({@Tag(REGRESSION), @Tag(SMOKE)})
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void fileUploadTest() {
        UserCredentials userCredentials = new UserCredentials(USER_NAME, PASSWORD);
        Token token = AuthenticationRestService.authenticateUser(userCredentials, SC_OK_JSON_NOT_NULL);
        String roomName = "Dataroom4";
        Long adminId = 155392L;

        //CreateNewRoom
        Node node1 = new Node(roomName, List.of(adminId));
        DataRoom room1 = NodesRestService.createNewRoom(node1, token, SC_CREATED_JSON_NOT_NULL);
        assertThat(room1).extracting(DataRoom::getType, DataRoom::getName)
            .containsExactly("room", roomName);

        //UploadFile
        File file = new File(FILE_TXT);
        UploadFilePayload uploadFilePayload = new UploadFilePayload(file.getName(), file.length(), room1.getId());
        Upload upload = NodesRestService.upload(token, uploadFilePayload, SC_CREATED_JSON_NOT_NULL);

        // upload the file
        UploadResponse response =
            UploadsRestService.uploadFile(token, upload.getToken(), extractBytes(FILE_TXT), getContentLength(FILE_TXT), SC_CREATED_JSON_NOT_NULL);
        assertThat(response).as("size Should not be null").extracting(UploadResponse::getSize).isNotEqualTo(0);

        // complete the upload
        UploadRequestPayload uploadRequestPayload = new UploadRequestPayload();
        CompletedUploadResponse completedUploadResponse = UploadsRestService.completeUpload(upload.getToken(), uploadRequestPayload, SC_CREATED_JSON_NOT_NULL);
        assertThat(completedUploadResponse).as("completedUploadResponse")
            .extracting(CompletedUploadResponse::getType, CompletedUploadResponse::getName,
                CompletedUploadResponse::getParentPath, firstName -> firstName.createdBy.getFirstName())
            .containsExactly("file", file.getName(), formatName(roomName), "Priyatham");
    }

}

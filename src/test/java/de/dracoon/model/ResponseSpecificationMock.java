package de.dracoon.model;

import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;

/**
 * @author priyatham.bolli
 */
public class ResponseSpecificationMock {

    private ResponseSpecificationMock() {
    }

    public static ResponseSpecification expectedResponse(int expectedStatusCode, Matcher<?> expectedBody) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectBody(expectedBody);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification expectedResponseForEmptyList(int expectedStatusCode, Matcher<?> expectedBody) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectBody("", expectedBody);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification expectedResponse(int expectedStatusCode, ContentType expectedContentType, Matcher<?> expectedBody) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectContentType(expectedContentType);
        responseSpecBuilder.expectBody(expectedBody);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification expectedResponse(int expectedStatusCode, String expectedContentType, Matcher<?> expectedBody) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectContentType(expectedContentType);
        responseSpecBuilder.expectBody(expectedBody);
        return responseSpecBuilder.build();
    }

    private static ResponseSpecification expectedResponse(int expectedStatusCode, ContentType contentType) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectContentType(contentType);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification expectedErrorResponse(int expectedStatusCode, ContentType contentType,
        String jsonPathExpression, String jsonPathValue) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectBody(jsonPathExpression, is(jsonPathValue));
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecBuilder.expectContentType(contentType);
        return responseSpecBuilder.build();
    }

    public static final ResponseSpecification SC_UNAUTHORIZED_NOT_NULL = expectedResponse(SC_UNAUTHORIZED, JSON, notNullValue());
    public static final ResponseSpecification SC_OK_JSON_NOT_NULL = expectedResponse(SC_OK, JSON, notNullValue());
    public static final ResponseSpecification SC_CREATED_JSON_NOT_NULL = expectedResponse(SC_CREATED, JSON, notNullValue());
    public static final ResponseSpecification SC_NO_CONTENT_NULL_VALUE = expectedResponse(SC_NO_CONTENT, blankOrNullString());
    public static final ResponseSpecification SC_OK_IMAGE_NOT_NULL = expectedResponse(SC_OK, "image/png;charset=UTF-8", notNullValue());

}

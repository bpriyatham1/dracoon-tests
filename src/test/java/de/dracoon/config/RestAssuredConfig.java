package de.dracoon.config;

import static de.dracoon.staticdata.RestUriPath.API_BASE_PATH;
import static de.dracoon.staticdata.RestUriPath.HOST_URL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author priyatham.bolli
 */
public class RestAssuredConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAssuredConfig.class);
    private static final RestAssuredConfig INSTANCE = new RestAssuredConfig();

    private RestAssuredConfig() {
        LOGGER.info("Configuring Rest Assured... ");
        RestAssured.reset();
        ObjectMapper objectMapper = ObjectMapperConfig.getInstance().getMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.replaceFiltersWith(new AllureRestAssured());
    }

    public RequestSpecification dracoonApiRequestSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(HOST_URL);
        builder.setBasePath(API_BASE_PATH);
        return builder.build();
    }

    public static RestAssuredConfig getInstance() {
        return INSTANCE;
    }

}

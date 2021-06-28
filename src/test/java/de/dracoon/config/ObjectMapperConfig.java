package de.dracoon.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author priyatham.bolli
 */
public final class ObjectMapperConfig {

    private static final ObjectMapperConfig INSTANCE = new ObjectMapperConfig();

    private final ObjectMapper mapper;

    private ObjectMapperConfig() {
        this.mapper = new ObjectMapper();
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.mapper.findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Creates a new instance of the {@link ObjectMapperConfig} with a pre-configured object mapper.
     *
     * @return {@link ObjectMapperConfig}
     */
    public static ObjectMapperConfig getInstance() {
        return INSTANCE;
    }

}

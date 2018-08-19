package com.lynk.system.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lynk.system.config.JsonConfig;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.json.LocalDateTimeDeserializer;
import com.lynk.system.json.LocalDateTimeSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Lynk
 * @since 2018/01/11
 */
public class JsonBuilder {
    private ObjectMapper objectMapper;

    private JsonBuilder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 不显示null的字段
     * @return
     */
    public static JsonBuilder builder() {
        return builder(false);
    }

    /**
     *
     * @param includeNull 是否显示包含null的值，转换后的值是null
     * @return
     */
    public static JsonBuilder builder(boolean includeNull) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(javaTimeModule)
                .registerModule(simpleModule);
        if (!includeNull) {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        return new JsonBuilder(objectMapper);
    }

    /**
     * 转换为字符串
     * @param object
     * @return
     * @throws SystemException
     */
    public String bean2Json(Object object) throws SystemException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SystemException(ErrorCode.SYS008, e);
        }
    }

    /**
     * 转换为Bean
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws SystemException
     */
    public <T> T json2Bean(String json, Class<T> clazz) throws SystemException {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new SystemException(ErrorCode.SYS008, e);
        }
    }
}

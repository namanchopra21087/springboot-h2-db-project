package com.h2.db.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseObject(
    String message, Map<String, String> errors, Object metaData, String code) {}

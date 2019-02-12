package com.taylor.cloud.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public final class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static JsonNode str2JsonNode(String str) {
    try {
      return OBJECT_MAPPER.readTree(str);
    } catch (IOException e) {
      return null;
    }
  }
}

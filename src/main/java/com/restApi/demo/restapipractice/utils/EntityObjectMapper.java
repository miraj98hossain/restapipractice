package com.restApi.demo.restapipractice.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityObjectMapper {

	public <T> T objectMapperReadValue(String content, Class<T> valueType) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(content,
					valueType);

		} catch (JsonParseException e) {

			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

	}

}

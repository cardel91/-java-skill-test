package com.example.restfulwebservices.controller;

import java.io.IOException;

import com.example.restfulwebservices.model.Model;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ModelSerializer extends JsonSerializer<Model> {

	@Override
	public void serialize(Model value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		gen.writeString(value.getId());
	}
}


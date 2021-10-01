package com.example.restfulwebservices.controller;

import java.io.IOException;
import java.util.List;

import com.example.restfulwebservices.model.Model;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ModelListSerializer extends JsonSerializer<List<Model>> {


	@Override
	public void serialize(List<Model> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		String[] arr = new String[value.size()];
		for (int i=0; i<value.size(); i++)
			arr[i] = value.get(i).getId();
		gen.writeArray(arr, 0, value.size());
	}
}

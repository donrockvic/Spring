package com.rest.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File("src/resources/sample.json"), Student.class);
        System.out.println(student);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("src/resources/output.json"), student);
    }
}

package com.gb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
//        Student student = new Student(1, "Bob");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objectMapper.writeValue(new File("student.json"), student);

        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(new File("student.json"), Student.class);
        student.info();
    }
}

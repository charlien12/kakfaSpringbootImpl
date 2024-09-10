package com.kafka.implementaion.server.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import org.springframework.stereotype.Component;

@Component
@JacksonXmlRootElement(namespace = "UsersEntityDto")
public class UsersEntityDto {
    private int id;
    private String name;
    private String age;
    @JacksonXmlElementWrapper
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JacksonXmlElementWrapper
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JacksonXmlElementWrapper
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UsersEntityDto(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public UsersEntityDto(){

    }
}

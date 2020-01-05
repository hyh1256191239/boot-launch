package com.hyh.bootlaunch.Model.yaml;

import lombok.Data;

import java.util.List;

@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
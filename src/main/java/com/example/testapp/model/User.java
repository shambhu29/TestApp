package com.example.testapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private int age;
    private String city;
    private Gender gender;
    private Category category;
    private String fathersName;
    private String mothersName;
}

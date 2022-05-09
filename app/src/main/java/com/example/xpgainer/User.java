package com.example.xpgainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String name, email, age;
    public int level, experience;

    public User(){

    }

    public User(String name, String age, String email,int level, int experience){
        this.name = name;
        this.age = age;
        this.email = email;
        this.level = level;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

}

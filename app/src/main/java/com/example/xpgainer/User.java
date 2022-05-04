package com.example.xpgainer;

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
                '}';
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

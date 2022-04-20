package com.example.xpgainer;

public class User {

    private String name, email, age, password;
    public int level, experience;

    public User(){

    }

    public User(String name, String age, String email,String password,int level, int experience){
        this.name = name;
        this.age = age;
        this.email = email;
        this.level = level;
        this.experience = experience;
        this.password = password;
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

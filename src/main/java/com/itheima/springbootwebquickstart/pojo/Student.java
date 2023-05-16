package com.itheima.springbootwebquickstart.pojo;

public class Student {
    private String username;
    private String age;
    private String gender;
    private String password;


    public Student(String username, String age, String gender, String password) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

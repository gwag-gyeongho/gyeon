package com.example.myproject;

public class Jinuk extends Person {
    String job;
    String MBTI;

    Jinuk(String name, int age, String job, String MBTI) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.MBTI = MBTI;
    }

    void introduce() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("직업: " + job);
        System.out.println("MBTI: " + MBTI);
    }
}

package com.example.myproject;
public class GirlFriend extends Jinuk {
    int like;

    GirlFriend(String name, int age, String job, String MBTI, int like) {
        super(name, age, job, MBTI);
        this.like = like;
    }

    void increaseLike(int amount) {
        like += amount;
    }
}

package com.nearu.servlet;

public class test {
    public static void main(String[] args){
        for (int rank = 1; rank <= 4; rank++) {
            for (int age = 1; age <= 30; age++) {
                for (int score = 0; score < 100; score++) {
                    if(rank * age * score == 2910){
                        System.out.println("rank:" + rank + " age:" + age+ " score:" + score);
                    }
                }
            }
        }
    }
}

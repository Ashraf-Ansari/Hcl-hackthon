package com.hcl.hackathon.testing;

@FunctionalInterface
public interface FN {
    int v = 5;
    int sum(int f1,int f2,int f3);
    default void printMethod(){
        System.out.println(v);
    }
    static void print(){}
}

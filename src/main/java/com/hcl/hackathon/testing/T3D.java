package com.hcl.hackathon.testing;

import java.util.ArrayList;
import java.util.List;

public class T3D {
    private int a;
    private int b;
    private int c;
    
    static List<T3D> v = new ArrayList<>();
    
    public T3D(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void getAdd(T3D input){
        v.add(input);
    }
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }
    
    public int getB() {
        return b;
    }
    
    public void setB(int b) {
        this.b = b;
    }
    
    public int getC() {
        return c;
    }
    
    public void setC(int c) {
        this.c = c;
    }
    
    public static void  forEach(FN input){
        v.forEach(i->input.sum(i.getA(),i.getB(),i.getC()));
    }
}

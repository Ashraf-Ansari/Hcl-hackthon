package com.hcl.hackathon.testing;

public class SingletonClass {
//   bill pugh solution  eager loading
    private SingletonClass(){}
    
    private static class staticClass{
        private static final SingletonClass obj = new SingletonClass();
    }
    
    public static SingletonClass getInstace(){
        return staticClass.obj;
    }
    
//    lazy loading
    private static volatile SingletonClass instance;
    public static SingletonClass getObject(){
        if(instance==null){
            synchronized(SingletonClass.class) {
                if(instance==null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
    
}

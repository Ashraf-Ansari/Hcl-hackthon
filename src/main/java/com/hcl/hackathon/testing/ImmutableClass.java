package com.hcl.hackathon.testing;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {
    private final String name;
    private final List<String> obj;
    
    public ImmutableClass(String name1,List<String> obj1){
        this.name=name1;
        this.obj = obj1;
    }
    
    public String getName(){
        return name;
    }
    
    public List<String> getNameList(){
        return new ArrayList<>(obj);
    }
    
}

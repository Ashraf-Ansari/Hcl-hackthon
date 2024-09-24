package com.hcl.hackathon.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestInterview {
    
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("1Mirags","3Ha7Jsk","6kk8","8uui7");
        
        List<String> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        set.add('0');set.add('1');set.add('2');set.add('3');set.add('4');set.add('5');set.add('6');set.add('7');
        set.add('8');set.add('9');
        for(int i=0;i<arr.size();i++){
            String arrObject = arr.get(i);
            String temp = "";
            for(int j=0;j<arrObject.length();j++){
                Character tempC = arrObject.charAt(j);
                if(!set.contains(tempC)){
                    temp += tempC;
                }
            }
            list.add(temp);
        }
        System.out.println(list);
    }
    
}


//we have two table employee and employee details ,
//employee - id, name , email
//employee details - employee id,and department

// select * from employee e inner join employee_details ed on e.id=ed.employee_id where department= "IT";

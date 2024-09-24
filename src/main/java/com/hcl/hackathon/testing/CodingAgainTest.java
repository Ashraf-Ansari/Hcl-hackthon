package com.hcl.hackathon.testing;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;

public class CodingAgainTest {
    
    public static void main(String[] args) {
//        findSecondLargest();
//        Employee v = new Employee("","","",15,"Ashraf");
//        List<Employee> list = Arrays.asList(new Employee("", "", "",15,"Ashraf"),new Employee("", "", "",13,"Ashraf"),new Employee("", "", "",12,"Ashraf878"),new Employee("", "", "",14,"Ahraf"),v,v);
//        Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(i -> i.getName(), Collectors.averagingDouble(i -> i.getAge())));
//        List<Employee> sorted = list.stream().distinct().sorted((i, j) -> i.getName().compareTo(j.getName())).toList();
//        list.stream().mapToInt(Employee::getAge).average();
//        System.out.println(sorted);
//        Comparator<String> obj = (i,j)->i.compareTo(j);
//        Comparator<String> obj1 = (i,j)->i.compareTo(j);
//        List<String> jkdj= Arrays.asList("A","BC");
//        String reduce = jkdj.stream().reduce("", (i, j) -> Integer.compare(i.length(), j.length()) >= 0 ? i : j);
//        System.out.println(reduce);
//        jkdj.sort(obj.thenComparing(obj1));
//        FN v = (a,b,c)-> a+b+c;
//        FN v1 = (a,b,c)-> a*b*c;
//        FN v2 = (a,b,c)-> {
//            System.out.println("{}"+a+b+c);
//            return 0;
//        };
//        T3D vobj = new T3D(1,2,3);
//        vobj.getAdd(new T3D(1,4,3));
//        vobj.getAdd(new T3D(5,2,7));
//        T3D.forEach((a,b,c)-> {
//            System.out.println("{}"+a+b+c);
//            return 0;
//        });
//        System.out.println(v2.sum(5,2,3));
        List<String> list = Arrays.asList("C","A");
        System.out.println(list);
        
    }
    
    public static void findSecondLargest(){
        List<Integer> arr = Arrays.asList(14,13,11,15,20,12);
        int n = arr.size();
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        
        for(int i = 0;i<n;i++){
            int v = arr.get(i);
            if(v>firstMax){
                secMax = firstMax;
                firstMax = v;
            }else if(v>secMax){
                secMax=v;
            }
        }
        System.out.println(firstMax+" "+secMax);
        
    }

}

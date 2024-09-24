package com.hcl.hackathon.testing;

public class Employee {
    
    String name;
    int age;
    String department;
    String designation;
    String salary;
    
    public Employee(String salary, String designation, String department, int age, String name) {
        this.salary = salary;
        this.designation = designation;
        this.department = department;
        this.age = age;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
}

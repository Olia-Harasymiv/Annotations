package org.example;

public class MyClass {
    @Annotations(firstName = "Harry")
    public int age;
    @Annotations(firstName = "Harry")
    String name;

    String lastName;


    public String greeting(String name) {
        return "Hello " + name;
    }
    public Integer age(Integer age) {
        return age;
    }
    public Double accountSum(Double str) {
        return 100 + str;
    }

    public void myMethod(String a, int... b){
        System.out.println("Text is shown after running the method with string and int...");
    }

    public void myMethod(String ... args){
        System.out.println("Text is shown after running the method with string...");
    }
}
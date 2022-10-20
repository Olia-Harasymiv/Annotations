package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        //getAnnotationFile();
       //getAnnotationValues();
       //invokeMethods();
       //setFieldValues();
       //myMethod();
       showClassInfo();
    }


    public static void getAnnotationFile() throws Exception {
        Class someClass = MyClass.class;
        Field[] fields = someClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Annotations.class)) {
                System.out.println(field);
            }
        }
    }

    public static void getAnnotationValues() throws Exception {
        Class someClass = MyClass.class;
        Field[] fields = someClass.getDeclaredFields();
        for (Field annot : fields) {
            Annotations customAnnotation = annot.getDeclaredAnnotation(Annotations.class);
            if (customAnnotation != null)
                System.out.println(customAnnotation.firstName());
        }
    }

    public static void invokeMethods() throws Exception {
        Class<?> myClass = MyClass.class;
        Method method = myClass.getMethod("greeting", String.class);
        Object obj = myClass;
        String output = (String) method.invoke(obj, "Harry");
        System.out.println(output);


        Method method1 = myClass.getMethod("age", Integer.class);
        Integer outputAge = (Integer) method1.invoke(obj, 20);
        System.out.println("Your age " + outputAge);

        Method method2 = myClass.getMethod("accountSum", Double.class);
        Double outputSum = (Double) method2.invoke(obj, 10000);
        System.out.println("Your account balance is " + outputSum);

    }

    public static void setFieldValues() throws Exception {
        Class<?> classObj = MyClass.class;
        Field ageField = classObj.getDeclaredField("age");
        Object person = classObj;
        ageField.setInt(person, 34);
        Object ageValue = ageField.get(person);
        System.out.println("age = " + ageValue);
    }

    public static void myMethod() throws Exception {
        Class<?> someClass = MyClass.class;
        Method method = someClass.getMethod("myMethod", String[].class);
        Object obj = someClass.newInstance();
        method.invoke(obj, (Object) new String[]{"There is some text", "Some text 2"});

        Method method2 = someClass.getMethod("myMethod", String.class, int[].class);
        method2.invoke(obj, "Some text", (Object) new int[]{1, 2, 3});
    }

    public static void showClassInfo() throws Exception {
        Class<?> classObj = MyClass.class;
        Method[] methods = classObj.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Constructor[] constructors = classObj.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Field[] fields = classObj.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }


}
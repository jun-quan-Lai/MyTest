package com.ljq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("jack");
        student1.setAge(15);

        Student student2 = new Student();
        student2.setName("pomny");
        student2.setAge(20);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        students.stream().filter(v->"mark".equals(v.getName()))
                .findFirst();

        System.out.println("haha");
    }


    static class Student{
        static private String name;
        static int age;

        static public String getName() {
            return name;
        }

        static public void setName(String name) {
            name = name;
        }

        static public int getAge() {
            return age;
        }

        static public void setAge(int age) {
            age = age;
        }
    }
}

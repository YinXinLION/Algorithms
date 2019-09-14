package com.lion.domain;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Teacher teacher = new Teacher();
//        Student student = new Student("yx");
//        Student student1 = new Student("yy");
//        List<Student> s = new ArrayList<>();
//        s.add(student);
//        s.add(student1);
//        teacher.setStudentList(s);
//        Teacher teacher1 = new Teacher();
//        Student student2 = new Student("yxyy");
//        Student student3 = new Student("yyyy");
//        List<Student> s1 = new ArrayList<>();
//        s.add(student2);
//        s.add(student3);
//        teacher.setStudentList(s1);
//        List<Teacher> teachers = new ArrayList<>();
//        teachers.add(teacher);
//        teachers.add(teacher1);
//        for (Teacher tea : teachers) {
//            System.out.println(tea);
//            Student st1 = new Student("ttt");
//            Student st2 = new Student("www");
//            List<Student> new1 = new ArrayList<>();
//            new1.add(st1);
//            new1.add(st2);
//            tea.setStudentList(new1);
//        }

        List<Stu> list = new ArrayList<>();
        Stu stu1 = new Stu(1);
        Stu stu2 = new Stu(2);
        Stu stu3 = new Stu(3);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for(Stu stu : list){
            stu = new Stu(stu.getValue() + 1);
            System.out.println(stu);
        }
        for(Stu s : list){
            System.out.println(s);
        }

////        System.out.println(teachers);
//        List<Stu> list = new ArrayList<>();
//        list.add(new Stu(1));
//        list.add(new Stu(2));
//        list.add(new Stu(3));
//        for(Stu stu : list){
//            stu = new Stu(stu.getValue() + 1);
//        }
//        for(Stu s : list){
//            System.out.println(s);
//        }
    }
}

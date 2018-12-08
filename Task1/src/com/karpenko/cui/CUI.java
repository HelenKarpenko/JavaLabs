package com.karpenko.cui;

import com.karpenko.student.Student;
import com.karpenko.student.Students;

import java.util.List;
import java.util.Map;

public class CUI {

    public static void showTitle(String message) {
        System.out.println(message);
    }

    public static void showLine() {
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void showStudents(List<Student> students) {
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public static void showStudents(Map<Integer, Student> students) {
        for (Student st : students.values()) {
            System.out.println(st);
        }
    }

    public static void showStudentsByFacultyAndGroup(Map<String, Map<Integer, List<Student>>> students) {
        for (var byFaculty : students.entrySet()) {
            System.out.printf("Faculty: %s\n", byFaculty.getKey());
            for (var byCourse : byFaculty.getValue().entrySet()) {
                System.out.printf("\tCourse: %s\n", byCourse.getKey());
                for (var student : byCourse.getValue()) {
                    System.out.printf("\t\t%s\n", student);
                }
            }
        }
    }
}

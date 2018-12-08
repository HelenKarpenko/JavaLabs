package com.karpenko.main;

import com.karpenko.cui.CUI;
import com.karpenko.student.Student;
import com.karpenko.student.Students;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Students students = getStudents();

        CUI.showLine();
        CUI.showTitle("All students:");
        CUI.showLine();
        CUI.showStudents(students.getStudent());

        String faculty = "F1";
        CUI.showLine();
        CUI.showTitle(String.format("Students by faculty: %s", faculty));
        CUI.showLine();
        CUI.showStudents(students.getStudentsByFaculty(faculty));

        CUI.showLine();
        CUI.showTitle("Students by faculty and course:");
        CUI.showLine();
        CUI.showStudentsByFacultyAndGroup(students.getStudentsForEachFacultyAndCourse());

        int year = 1999;
        CUI.showLine();
        CUI.showTitle(String.format("Students who were born after %d", year));
        CUI.showLine();
        CUI.showStudents(students.getStudentsWhoWereBornAfter(year));

        String group = "KP-62";
        CUI.showLine();
        CUI.showTitle(String.format("Students by group: %s", group));
        CUI.showLine();
        CUI.showStudents(students.getStudentsByGroup(group));
    }

    private static Students getStudents() {
        Student st1 = new Student.Builder()
                .setId(1)
                .setFirstName("Lena")
                .setLastName("Karpenko")
                .setPatronymic("Alexandrovna")
                .setYear(1999)
                .setAddress("Kyiv")
                .setPhone("12345")
                .setFaculty("F1")
                .setGroup("KP-61")
                .setCourse(3)
                .build();

        Student st2 = new Student.Builder()
                .setId(2)
                .setFirstName("Alex")
                .setLastName("Pupkin")
                .setPatronymic("Alexandrov")
                .setYear(1999)
                .setAddress("Kyiv")
                .setPhone("12345")
                .setFaculty("F1")
                .setGroup("KP-62")
                .setCourse(3)
                .build();

        Student st3 = new Student.Builder()
                .setId(3)
                .setFirstName("Ivan")
                .setLastName("Pupkin")
                .setPatronymic("Pupkovich")
                .setYear(2001)
                .setAddress("Kyiv")
                .setPhone("12345")
                .setFaculty("F1")
                .setGroup("KP-62")
                .setCourse(3)
                .build();

        Student st4 = new Student.Builder()
                .setId(4)
                .setFirstName("Ivan")
                .setLastName("Pupkin")
                .setPatronymic("Pupkovich")
                .setYear(2000)
                .setAddress("Kyiv")
                .setPhone("12345")
                .setFaculty("F2")
                .setGroup("KL-62")
                .setCourse(3)
                .build();

        Students students = new Students();
        students.addStudent(st1);
        students.addStudent(st2);
        students.addStudent(st3);
        students.addStudent(st4);

        return students;
    }
}



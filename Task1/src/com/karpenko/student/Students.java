package com.karpenko.student;

import java.util.*;
import java.util.stream.Collectors;

public class Students {
    private Map<Integer, Student> students;

    public Students() {
        students = new HashMap<>();
    }

    public Map<Integer, Student> getStudent() {
        return students;
    }

    public void addStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("student must not be null.");

        students.put(student.getId(), student);
    }

    public void removeStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("student must not be null.");

        students.remove(student.getId());
    }

    public List<Student> getStudentsByFaculty(String faculty) {
        if (faculty == null)
            throw new IllegalArgumentException("Faculty must not be null.");

        List<Student> studentsByFaculty = new LinkedList<>();

        for (Student st : students.values()) {
            if (st.getFaculty().equals(faculty)) {
                studentsByFaculty.add(st);
            }
        }

        return studentsByFaculty;
    }

    public List<Student> getStudentsWhoWereBornAfter(int year) {
        if (year <= 0)
            throw new IllegalArgumentException("Incorrect year.");

        List<Student> studentByDateOfBirth = new LinkedList<>();

        for (Student st : students.values()) {
            if (st.getYear() > year) {
                studentByDateOfBirth.add(st);
            }
        }

        return studentByDateOfBirth;
    }

    public List<Student> getStudentsByGroup(String group) {
        if (group == null)
            throw new IllegalArgumentException("Group must not be null.");

        List<Student> studentsByGroup = new LinkedList<>();

        for (Student st : students.values()) {
            if (st.getGroup().equals(group)) {
               studentsByGroup.add(st);
            }
        }
        return studentsByGroup;
    }

    public Map<String, Map<Integer, List<Student>>> getStudentsForEachFacultyAndCourse() {

        return students
                .values()
                .stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.groupingBy(Student::getCourse)));
    }
}

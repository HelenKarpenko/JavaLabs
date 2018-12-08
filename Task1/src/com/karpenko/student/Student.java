package com.karpenko.student;

import java.util.Date;

public final class Student implements Cloneable {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final int year;
    private final String address;
    private final String phone;
    private final String faculty;
    private final int course;
    private final String group;

    private Student(Builder builder) {
        if (builder == null)
            throw new IllegalArgumentException("Builder must not be null.");

        id = builder.id;
        lastName = builder.lastName;
        firstName = builder.firstName;
        patronymic = builder.patronymic;
        year = builder.year;
        address = builder.address;
        phone = builder.phone;
        faculty = builder.faculty;
        course = builder.course;
        group = builder.group;
    }

    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public int getYear() {
        return year;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getCourse() {
        return course;
    }
    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(String.format("Id: %d", id));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Full name: %s %s %s", lastName, firstName, patronymic));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Date of birth: %d", year));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Address: %s", address));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Phone: %s", phone));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Faculty: %s", faculty));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Course: %d", course));
        strBuilder.append(" | ");
        strBuilder.append(String.format("Group: %s", group));
        strBuilder.append(" | ");

        return strBuilder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 17 + id;
        hash = hash * 31 + lastName.hashCode();
        hash = hash * 31 + firstName.hashCode();
        hash = hash * 31 + patronymic.hashCode();
        hash = hash * 31 + year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        if (id != student.id) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!patronymic.equals(student.patronymic)) return false;
        if (year != student.year) return false;
        if (!address.equals(student.address)) return false;
        if (!phone.equals(student.phone)) return false;
        if (!faculty.equals(student.faculty)) return false;
        if (course != student.course) return false;
        if (!group.equals(student.group)) return false;

        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private String patronymic;
        private int year;
        private String address;
        private String phone;
        private String faculty;
        private int course;
        private String group;

        public Builder setId(int id) {
            if (id <= 0)
                throw new IllegalArgumentException("Incorrect student id.");

            this.id = id;
            return this;
        }

        public Builder setLastName(String lastName) {
            if (lastName == null)
                throw new IllegalArgumentException("lastName must not be null.");

            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            if (firstName == null)
                throw new IllegalArgumentException("firstName must not be null.");

            this.firstName = firstName;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            if (patronymic == null)
                throw new IllegalArgumentException("patronymic must not be null.");

            this.patronymic = patronymic;
            return this;
        }

        public Builder setYear(int year) {
            if (year <= 0)
                throw new IllegalArgumentException("Incorrect year.");

            this.year = year;
            return this;
        }

        public Builder setAddress(String address) {
            if (address == null)
                throw new IllegalArgumentException("address must not be null.");

            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            if (phone == null)
                throw new IllegalArgumentException("phone must not be null.");

            this.phone = phone;
            return this;
        }

        public Builder setFaculty(String faculty) {
            if (faculty == null)
                throw new IllegalArgumentException("faculty must not be null.");

            this.faculty = faculty;
            return this;
        }

        public Builder setCourse(int course) {
            if (course <= 0)
                throw new IllegalArgumentException("course must be greater than zero");
            if (course > 6)
                throw new IllegalArgumentException("course must be less than 7");

            this.course = course;
            return this;
        }

        public Builder setGroup(String group) {
            if (group == null)
                throw new IllegalArgumentException("group must not be null.");

            this.group = group;
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }
}

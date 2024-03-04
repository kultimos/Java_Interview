package foundation.forCompare;

import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.getId();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class forComparable {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(4, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(1, "Cathy"));
        Collections.sort(students);
        System.out.println("Sorted students using Comparable:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

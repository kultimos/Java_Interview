package foundation.forCompare;

import java.util.*;
import java.util.stream.Collectors;

class StudentC {
    private int id;
    private String name;

    public StudentC(int id, String name) {
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
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class IdComparator implements Comparator<StudentC> {
    @Override
    public int compare(StudentC s1, StudentC s2) {
        return s1.getId() - s2.getId();
    }
}

public class forComparator {
    public static void main(String[] args) {
        List<StudentC> students = new ArrayList<>();
        students.add(new StudentC(3, "Alice"));
        students.add(new StudentC(1, "Bob"));
        students.add(new StudentC(2, "Cathy"));
        Collections.sort(students, new IdComparator());
        Collections.sort(students, ((o1, o2) -> o2.getId() - o1.getId()));
        System.out.println("Sorted students using Comparator:");
        for (StudentC student : students) {
            System.out.println(student);
        }
        Map<String, StudentC> studentMap1 = students.stream().collect(Collectors.toMap(s -> s.getName(), s->s));
        Map<String, StudentC> studentMap2 = students.stream().collect(Collectors.toMap(StudentC::getName, k -> k));
        System.out.println(studentMap1);
        System.out.println("----------------------");
        System.out.println(studentMap2);
    }
}

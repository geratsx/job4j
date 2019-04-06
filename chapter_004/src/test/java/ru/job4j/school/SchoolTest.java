package ru.job4j.school;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolTest {


    private School school = new School();
    private Student student1 = new Student(10, "Petya");
    private Student student2 = new Student(60, "Vasya");
    private Student student3 = new Student(80, "Misha");
    private List<Student> students = Arrays.asList(student1, student2, student3);


    @Test
    public void whenStudentScoreBetween0And50() {
        List<Student> expect = Arrays.asList(new Student(10));
        List<Student> result = school.collect(students, (x) -> x.getScore() >= 0 && x.getScore() < 50);
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentScoreBetween50And70() {
        List<Student> expect = Arrays.asList(new Student(60));
        List<Student> result = school.collect(students, (x) -> x.getScore() > 50 && x.getScore() <= 70);
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentScoreBetween70And100() {
        List<Student> expect = Arrays.asList(new Student(80));
        List<Student> result = school.collect(students, (x) -> x.getScore() > 70 && x.getScore() <= 100);
        assertThat(result, is(expect));
    }

    @Test
    public void whenHaveListStudentsThenGetMapStudents() {
        Map<String, Student> expect = new HashMap<>();
        expect.put(student1.getName(), student1);
        expect.put(student2.getName(), student2);
        expect.put(student3.getName(), student3);
        Map<String, Student> result = school.getMapStudentsFromList(students);
        assertThat(expect, is(result));
    }
}

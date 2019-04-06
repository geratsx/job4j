package ru.job4j.school;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class SchoolTest {


    School school = new School();
    List<Student> students = Arrays.asList(new Student(10), new Student(60), new Student(80));


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
}

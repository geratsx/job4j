package ru.job4j.school;

import java.util.Comparator;
import java.util.Objects;


public class Student implements Comparator<Student> {

    private int score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "score="
                + score
                + ", name='"
                + name
                + '\''
                + '}';
    }

     @Override
    public int compare(Student o1, Student o2) {
        return o2.getScore() - o1.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
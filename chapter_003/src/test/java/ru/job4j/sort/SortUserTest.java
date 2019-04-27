package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenHaveListOfUsersThenSortTheirByAge() {
        Set<User> result = new SortUser().sort(List.of(
                new User("Andrey", 25),
                new User("Ivan", 30),
                new User("Mihail", 40),
                new User("Roman", 50)

        ));
        Set<User> expect = Set.of(
                new User("Andrey", 25),
                new User("Ivan", 30),
                new User("Mihail", 40),
                new User("Roman", 50)
        );
        assertThat(result, is(expect));
    }


    @Test
    public void whenHaveListOfUsersThenSortTheirByNameLength() {
        List<User> users = Arrays.asList(
                new User("Andrey", 25),
                new User("Ivan", 30),
                new User("Alexander", 20),
                new User("Roman", 23)
        );
        List<User> result = new SortUser().sortNameLength(users);
        List<User> expect = List.of(
                new User("Ivan", 30),
                new User("Roman", 23),
                new User("Andrey", 25),
                new User("Alexander", 20)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenHaveListOfUsersThenSortTheirByNameAndAge() {
        List<User> users = Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );

        List<User> result = new SortUser().sortByAllFields(users);

        List<User> expect = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        assertThat(result, is(expect));
    }
}
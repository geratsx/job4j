package ru.job4j.convert;

import org.junit.Test;
import ru.job4j.convert.User;
import ru.job4j.convert.UserConvert;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConverterTest {

    @Test
    public void whenHaveListOfUsersThenConvertItToMap() {
        User user1 = new User(1, "Vasya", "Moscow");
        User user2 = new User(2, "Petya", "Kazan");
        User user3 = new User(3, "Vitaliy", "Voronezh");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        HashMap<Integer, User> input =  new UserConvert().process(users);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, user1);
        expect.put(2, user2);
        expect.put(3, user3);
        assertThat(input, is(expect));
    }
}
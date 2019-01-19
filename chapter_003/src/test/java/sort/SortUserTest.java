package sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenHaveListOfUsersThenSortTheirByAge() {
        SortUser sortUser = new SortUser();
        User u1 = new User("Andrey", 25);
        User u2 = new User("Ivan", 30);
        User u3 = new User("Mihail", 20);
        User u4 = new User("Roman", 23);
        List<User> users = Arrays.asList(u1, u2, u3, u4);
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new TreeSet<>(Comparator.comparingInt(User::getAge));
        expect.add(u1);
        expect.add(u2);
        expect.add(u3);
        expect.add(u4);
        assertThat(result, is(expect));
    }
}
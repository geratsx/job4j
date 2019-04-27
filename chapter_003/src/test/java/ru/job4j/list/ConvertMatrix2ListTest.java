package ru.job4j.list;

import org.junit.Test;
import ru.job4j.list.ConvertMatrix2List;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ConvertMatrix2List().toList(input);
        assertThat(result, is(expect));
    }
}
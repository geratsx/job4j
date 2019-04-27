package ru.job4j.list;

import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        List<Integer> resultList = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = new ConvertList2Array().toArray(resultList, 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen3Arrays() {
        List<Integer> resultList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] result = new ConvertList2Array().toArray(resultList, 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen1Array() {
        List<Integer> resultList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] result = new ConvertList2Array().toArray(resultList, 1);
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenListOfArraysThenListOfElements() {
        List<int[]> input = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
        );
        List<Integer> result = new ConvertList2Array().convert(input);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
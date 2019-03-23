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
        ConvertList2Array list = new ConvertList2Array();
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        resultList.add(4);
        resultList.add(5);
        resultList.add(6);
        resultList.add(7);
        int[][] result = list.toArray(resultList, 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen3Arrays() {
        ConvertList2Array list = new ConvertList2Array();
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        resultList.add(4);
        resultList.add(5);
        resultList.add(6);
        resultList.add(7);
        resultList.add(8);
        resultList.add(9);
        int[][] result = list.toArray(resultList, 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen1Array() {
        ConvertList2Array list = new ConvertList2Array();
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        resultList.add(4);
        resultList.add(5);
        resultList.add(6);
        resultList.add(7);
        resultList.add(8);
        resultList.add(9);
        int[][] result = list.toArray(resultList, 1);
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenListOfArraysThenListOfElements() {
        ConvertList2Array list = new ConvertList2Array();
        ArrayList<int[]> input = new ArrayList<>();
        int[] ar1 = {1, 2};
        int[] ar2 = {3, 4, 5, 6};
        input.add(ar1);
        input.add(ar2);
        List<Integer> result = list.convert(input);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        assertThat(result, is(expect));
    }
}

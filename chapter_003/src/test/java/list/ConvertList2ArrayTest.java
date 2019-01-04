package list;

import org.junit.Test;

import java.util.ArrayList;

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
}

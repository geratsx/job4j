package ru.job4j.matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenHaveMatrixOfNumbersThenGetListOfNumbers() {
        Matrix matrix = new Matrix();
        Integer[][] numbers = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = matrix.getListFromMatrixOfNumbers(numbers);
        assertThat(expect, is(result));
    }
}

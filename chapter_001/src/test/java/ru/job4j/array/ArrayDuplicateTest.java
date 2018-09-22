package ru.job4j.array;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input =  {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));

    }

    @Test
    public void whenHaveFiveHiThenOneHi() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input =  {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] expect = {"Привет"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
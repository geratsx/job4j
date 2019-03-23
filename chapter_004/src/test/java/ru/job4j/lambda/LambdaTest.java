package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.lambda.Lambda;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LambdaTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lambda lambda = new Lambda();
        List<Double> result = lambda.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadtraticResults() {
        Lambda lambda = new Lambda();
        List<Double> result = lambda.diapason(5, 8, x -> 2 * Math.sqrt(x) + 3 * x + 4);
        List<Double> expected = Arrays.asList(23.47213595499958D, 26.898979485566358D, 30.29150262212918D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogariphmFunctionTheLogariphmResults() {
        Lambda lambda = new Lambda();
        List<Double> result = lambda.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }
}

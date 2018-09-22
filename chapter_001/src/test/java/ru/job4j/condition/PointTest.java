package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenGetOtherPointLearnDistanceForIt() {
         int x1 = 2;
         int y1 = 3;
         int x2 = 5;
         int y2 = 6;
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        double result = point1.distanceTo(point2);
        double expected = 4.242640687119285;
        assertThat(result, closeTo(expected, 0.1));
    }
}
package coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMachineTest {

    @Test
    public void whenBill50ThenChange15() {
       CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenChangeNotNeed() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(50, 50);
        int[] expect = {0};
        assertThat(result, is(expect));
    }


    @Test(expected = SmallBillException.class)
    public void whenBillLessThenPrice() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(30, 50);
    }
}

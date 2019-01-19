package tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(Arrays.asList("invalid", "1")));
        input.ask("Enter", Arrays.asList(1));
        assertThat(this.mem.toString(), is("You enter not a number. Please, enter valid paragraph of menu." + System.lineSeparator()));
    }

    @Test
    public void whenInputNotInRange() {
        StubInput input =  new StubInput(Arrays.asList("31"));
        input.ask("Enter", Arrays.asList(2));
        assertThat(this.mem.toString(), is("Out of menu range. Please, select valid paragraph of menu." + System.lineSeparator()));
    }
}
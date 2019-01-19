package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    /**
     * Меню трекера в виде строки
     */
    private final StringBuilder menu = new StringBuilder()
            .append(System.lineSeparator())
            .append("0.Add new item")
            .append(System.lineSeparator())
            .append("1.Show all items")
            .append(System.lineSeparator())
            .append("2.Edit item")
            .append(System.lineSeparator())
            .append("3.Delete item")
            .append(System.lineSeparator())
            .append("4.Find item by id")
            .append(System.lineSeparator())
            .append("5.Find item by name")
            .append(System.lineSeparator())
            .append("6.Exit")
            .append(System.lineSeparator())
            .append(System.lineSeparator());

    @Test
    public void whenUserWontToSeeAllItemsThenPrintAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu.toString())
                        .append("List of all items: ")
                        .append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .append("Item name='")
                        .append(item1.getName())
                        .append("', ")
                        .append("desc='")
                        .append(item1.getDesc())
                        .append("', ")
                        .append("id='")
                        .append(item1.getId())
                        .append("'")
                        .append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .append(menu.toString())
                        .toString()
        ));
    }

    @Test
    public void whenUserInputIdThenTrackerPrintThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(Arrays.asList("4", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu.toString())
                        .append("-----------------Find item by Id-----------------")
                        .append(System.lineSeparator())
                        .append("Item name='")
                        .append(item.getName())
                        .append("', ")
                        .append("desc='")
                        .append(item.getDesc())
                        .append("', ")
                        .append("id='")
                        .append(item.getId())
                        .append("'")
                        .append(System.lineSeparator())
                        .append(menu.toString())
                        .toString()
        ));
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test replace", "заменили заявку", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(Arrays.asList("3", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertFalse(Arrays.asList(tracker.findAll()).contains(item));
    }

    @Test
    public void whenUserInputIdThenFindItemWithThisIdInTheTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(Arrays.asList("4", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenUserInputNameThenFindItemWithThisNameInTheTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        List<Item> items = Arrays.asList(item);
        Input input = new StubInput(Arrays.asList("5", item.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()), is(items));
    }
}
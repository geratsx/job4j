package tracker;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TrackerTest {

    @Test
    public void whenThereIsIdThenFindItInTheTracker() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }
    @Test
    public void whenAddNewItemThenItemInTheTracker() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenThereIsNameThenFindItInTheTracker() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("test name",  "test");
        tracker.add(newItem);
        Item[] items = new Item[1];
        items[0] = newItem;
        assertThat(tracker.findByName(newItem.getName()), is(items));

    }

    @Test
    public void whenTrackerHasItemsThenFindThemAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test name1", "test1");
        Item item2 = new Item("test name2", "test2");
        Item item3 = new Item("test name3", "test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] items = {item1, item2, item3};
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenGiveIdAndReplaceThenNewItemInTheTracker() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        Item next = new Item("123", "test name", "next");
        tracker.replace(previos.getId(), next);
        assertTrue(Arrays.asList(tracker.findAll()).contains(next));
    }


    @Test
    public void whenGiveIdAndReplaceThenOldItemNotInTheTracker() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        Item next = new Item("123", "test name", "next");
        tracker.replace(previos.getId(), next);
        assertFalse(Arrays.asList(tracker.findAll()).contains(previos));
    }


   @Test
    public void whenGiveIdAndDeleteThenOldItemNotInTracker() {
       Tracker tracker = new Tracker();
       Item previos = new Item("test name", "previos");
       tracker.add(previos);
       tracker.delete(previos.getId());
       assertFalse(Arrays.asList(tracker.findAll()).contains(previos));
   }
}
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenThereIsIdThenFindItInTheTracker() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenThereIsIdThenFindItInTheTrackerEnum() {
        TrackerEnum tracker = TrackerEnum.INSTANCE;
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenThereIsIdThenFindItInTheTrackerInner() {
        TrackerInner tracker = TrackerInner.getInstance();
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenThereIsIdThenFindItInTheTrackerStaticLazy() {
        TrackerStaticLazy tracker =  TrackerStaticLazy.getInstance();
        Item newItem = new Item("test name", "test");
        tracker.add(newItem);
        assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenThereIsIdThenFindItInTheTrackerStaticEager() {
        TrackerStaticEager tracker =  TrackerStaticEager.getInstance();
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
        List<Item> items = Arrays.asList(newItem);
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
        List<Item> items = Arrays.asList(item1, item2, item3);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenGiveIdAndReplaceThenNewItemInTheTracker() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        Item next = new Item("123", "test name", "next");
        tracker.replace(previos.getId(), next);
        assertTrue(tracker.findAll().contains(next));
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

    @Test
    public void whenDeleteItemButTrackerDoesNotHaveThisItemThenFalse() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        assertFalse(tracker.delete("111"));
    }

    @Test
    public void whenDeleteItemAndTrackerHaveThisItemThenTrue() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        assertTrue(tracker.delete(previos.getId()));
    }

    @Test
    public void whenEditItemButTrackerDoesNotHaveThisItemThenFalse() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        tracker.add(previos);
        Item next = new Item("test name2", "previos",  "111");
        assertFalse(tracker.replace("111", next));
    }

    @Test
    public void whenEditItemAndTrackerHaveThisItemThenTrue() {
        Tracker tracker = new Tracker();
        Item previos = new Item("test name", "previos");
        Item next = new Item("test name2", "previos", "111");
        tracker.add(previos);
        assertTrue(tracker.replace(previos.getId(), next));
    }
}
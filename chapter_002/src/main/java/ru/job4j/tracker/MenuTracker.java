package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует меню с помощью внутренних классов - событий
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    /**
     * Ввод данных
     */
    private Input input;
    /**
     * Трекер с заявками
     */
    private Tracker tracker;
    /**
     * Лист пунктов меню
     */
    private List<UserAction> actions = new ArrayList<>();
    private StartUI startUI;


    public MenuTracker(Input input, Tracker tracker, StartUI startUI) {
        this.input = input;
        this.tracker = tracker;
        this.startUI = startUI;
    }

    /**
     * Метод для получения размера списка меню
     * @return размер списка меню
     */
    public int getActionsLength() {
        return this.actions.size();
    }


    /**
     * Метод заполняет лист событий для отображения меню
     */
    public void fillActions() {
        this.actions.add(new AddItem(Integer.valueOf(StartUI.ADD), "Add new item"));
        this.actions.add(new ShowItems(Integer.valueOf(StartUI.SHOW), "Show all items"));
        this.actions.add(new MenuTracker.EditItem(Integer.valueOf(StartUI.EDIT), "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(Integer.valueOf(StartUI.DELETE), "Delete item"));
        this.actions.add(new FindItemById(Integer.valueOf(StartUI.FIND_BY_ID), "Find item by id"));
        this.actions.add(new FindItemByName(Integer.valueOf(StartUI.FIND_BY_NAME), "Find item by name"));
        this.actions.add(new ExitProgram(Integer.valueOf(StartUI.EXIT), "Exit"));
    }

    /**
     * Метод реализует логику выбора пункта меню пользователем
     * @param key ключ под которым лежит событие в листе
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод реализует логику печати меню в консоль
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс реализует событие добавления новой заявки в трекер
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню  с помощью {@link Tracker#add(Item)}
         * и печатает в консоль данные добавленной заявки
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------Adding a new item-----------------");
            String name = input.ask("Enter items name:");
            String desc = input.ask("Enter items description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("New item added with id = " + item.getId() + ", name = " + item.getName() + ", desc = " + item.getDesc());
        }
    }

    /**
     * Класс реализует показ всех заявок в трекере
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню с помощью {@link Tracker#findAll()}
         * и печатает в консоль список всех заявок
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("List of all items: ");
            System.out.println();
            List<Item> allItems = tracker.findAll();
            if (allItems.size() > 0) {
                for (Item item : allItems) {
                    System.out.println(item.toString());
                    System.out.println();
                }
            } else {
                System.out.println("No items in the tracker");
                System.out.println();
            }
        }
    }

    /**
     * Класс реализует редактирование заявки в трекере
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню с помощью {@link Tracker#replace(String, Item)}
         * и печатает в консоль измененную заявку
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Editing item-----------------");
            String id = input.ask("Enter items id to edit : ");
            String name = input.ask("Enter items name: ");
            String desc = input.ask("Enter items description: ");
            Item item = new Item();
            item.setName(name);
            item.setDesc(desc);
            if (tracker.replace(id, item)) {
                System.out.println("Item with id = " + id + " was successfully changed.");
            } else {
                System.out.println("Item with id = " + id + " not found.");
            }
        }
    }

    /**
     * Класс реализует удаление заявки из трекера
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню с помощью {@link Tracker#delete(String)}
         * и печатает в консоль id удаленной заявки
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Deleting item-----------------");
            String id = input.ask("Enter items id to delete : ");
            if (tracker.delete(id)) {
                System.out.println("Item with id = " + id + " was successfully deleted.");
            } else {
                System.out.println("Item with id = " + id + " not found.");
            }
        }
    }

    /**
     * Класс реализует поиск заявки в трекере по id
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private class FindItemById extends BaseAction {


        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню с помощью {@link Tracker#findById(String)}
         * и печатает в консоль найденную заявку
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Find item by Id-----------------");
            String id = input.ask("Enter items id for searching: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс реализует поиск заявки в трекере по имени
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует логику пункта меню с помощью {@link Tracker#findByName(String)}
         * и печатает в консоль найденную заявку
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Find item by name-----------------");
            String name = input.ask("Enter items name for searching: ");
            List<Item> items = tracker.findByName(name);
            if (items.size() > 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                    System.out.println();
                }
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс реализует выход из трекера
     * @see UserAction
     *
     * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует выход из меню {@link StartUI#init()}
         * @param input ввод данных
         * @param tracker трекер заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            startUI.setExit(true);
        }
    }
}
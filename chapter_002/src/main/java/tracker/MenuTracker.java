package tracker;



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

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

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
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemByName());
        this.actions.add(new ExitProgram());
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
    public class AddItem implements UserAction {

        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "0.Add new item";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#ADD
         */
        private final int add = Integer.parseInt(StartUI.ADD);

        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.add;
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

        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private class ShowItems implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "1.Show all items";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#SHOW
         */
        private final int showAll = Integer.parseInt(StartUI.SHOW);

        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.showAll;
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
            Item[] allItems = tracker.findAll();
            if (allItems.length > 0) {
                for (Item item : allItems) {
                    System.out.println(item.toString());
                    System.out.println();
                }
            } else {
                System.out.println("No items in the tracker");
                System.out.println();
            }
        }
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private static class EditItem implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "2.Edit item";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#EDIT
         */
        private final int edit = Integer.parseInt(StartUI.EDIT);
        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.edit;
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
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private static class DeleteItem implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "3.Delete item";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#DELETE
         */
        private final int delete = Integer.parseInt(StartUI.DELETE);

        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.delete;
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
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private class FindItemById implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "4.Find item by ID";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#FIND_BY_ID
         */
        private final int findItemById = Integer.parseInt(StartUI.FIND_BY_ID);
        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.findItemById;
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
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private class FindItemByName implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "5.Find item by name";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#FIND_BY_NAME
         */
        private final int findItemByName = Integer.parseInt(StartUI.FIND_BY_NAME);
        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.findItemByName;
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
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                    System.out.println();
                }
            } else {
                System.out.println("Item not found");
            }
        }
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
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
    private class ExitProgram implements UserAction {
        /**
         * Текст для отображения в меню
         */
        private final String menuInfo = "6.Exit";
        /**
         * Ключ пунта меню - добавление новой заявки в трекер
         * @see StartUI#EXIT
         */
        private final int exit = Integer.parseInt(StartUI.EXIT);
        /**
         * @return возвращает уникальный ключ пункта меню {@link UserAction#key()}
         */
        @Override
        public int key() {
            return this.exit;
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
        /**
         * @return текст пункта меню {@link UserAction#info()}
         */
        @Override
        public String info() {
            return this.menuInfo;
        }
    }
}
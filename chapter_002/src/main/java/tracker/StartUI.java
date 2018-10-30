package tracker;


/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 *
 * Класс реализует логику общения с пользователем в консоли и логику меню
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ID
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявки по имени
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа меню для выхода из меню
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя
     */
    private final Input input;
    /**
     * Хранилище заявок
     */
    private final Tracker tracker;


    /**
     * Конструктор, инициализирующий поля
     *
     * @param input   Ввод данных
     * @param tracker Хранилище заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    /**
     * Метод реализующий обработку выбранных пунктов меню
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Please select: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Please select correct paragraph of menu");
                System.out.println("------------------------------------------");
            }

        }
    }

    /**
     * Метод печатающий в консоль результат поиска заявки по имени в трекере
     * @see Tracker#findByName(String)
     */
    private void findItemByName() {
        System.out.println("-----------------Find item by name-----------------");
        String name = this.input.ask("Enter items name for searching: ");
        Item[] items = this.tracker.findByName(name);
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
     * Метод печатающий в консоль результат поиска заявки по id в трекере
     * @see Tracker#findById(String)
     */
    private void findItemById() {
        System.out.println("-----------------Find item by Id-----------------");
        String id = this.input.ask("Enter items id for searching: ");
        Item item = this.tracker.findById(id);
        if (!item.equals(null)) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found");
        }
    }

    /**
     * Метод удаляет заявку из трекера по команде пользователя
     * и выводит в консоль информацию об удаленной заявке
     * @see Tracker#delete(String)
     */
    private void deleteItem() {
        System.out.println("-----------------Deleting item-----------------");
        String id = this.input.ask("Enter items id to delete : ");
        this.tracker.delete(id);
        System.out.println("Item with id = " + id + " was successfully deleted.");
    }

    /**
     * Метод позволяет редактировать заявку в трекере.
     * Выводит результат редктирования в консоль
     * @see Tracker#replace(String, Item)
     */
    private void editItem() {
        System.out.println("-----------------Editing item-----------------");
        String id = this.input.ask("Enter items id to edit : ");
        String name = this.input.ask("Enter items name: ");
        String desc = this.input.ask("Enter items description: ");
        Item item = new Item();
        item.setName(name);
        item.setDesc(desc);
        this.tracker.replace(id, item);
        System.out.println("Item with id = " + id + " was successfully changed.");

    }

    /**
     * Метод позволяет печатает в консоль информацию
     * о всех заявках в трекере.
     * @see Tracker#findAll()
     */
    private void showAllItems() {
        System.out.println("List of all items: ");
        System.out.println();
        Item[] allItems = this.tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                System.out.println(item.toString());
                System.out.println();
            }
        } else {
            System.out.println("No items in the tracker");
        }
    }

    /**
     * Метод создает новую заявку и добавляет ее в трекер.
     * Выводит в консоль инормацию о созданной заявке
     * @see Tracker#add(Item)
     */
    private void createItem() {
        System.out.println("---------------Adding a new item-----------------");
        String name = this.input.ask("Enter items name:");
        String desc = this.input.ask("Enter items description:");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("New item added with id = " + item.getId());
    }

    /**
     * Реализация показа меню для пользователя в консоли.
     */
    private void showMenu() {
        System.out.println("Menu:");
        System.out.println();
        System.out.println("0.Add new item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find by item by ID");
        System.out.println("5.Find by item by name");
        System.out.println("6.Exit");
        System.out.println();
    }

    /**
     * Точка входа в программу.
     * Запускает StartUI
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
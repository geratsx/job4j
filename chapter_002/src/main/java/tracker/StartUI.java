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
    public static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок
     */
    public static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки
     */
    public static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки
     */
    public static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ID
     */
    public static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявки по имени
     */
    public static final String FIND_BY_NAME = "5";
    /**
     * Константа меню для выхода из меню
     */
    public static final String EXIT = "6";
    /**
     * Получение данных от пользователя
     */
    private final Input input;
    /**
     * Хранилище заявок
     */
    private final Tracker tracker;

    private boolean isExit = false;


    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this);
        menu.fillActions();

        do {
            System.out.println();
            menu.show();
            System.out.println();
            menu.select(Integer.parseInt((input.ask("Please, select: "))));
        } while (!isExit);
    }


    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
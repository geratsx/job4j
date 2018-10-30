package tracker;

import java.util.Scanner;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * @see tracker.Input
 * Класс реализует общение с пользователем через консоль.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Реализация метода для общения с пользователем в консоли
     * @see Input#ask
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
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
     * @param question вопрос пользователю
     * @see Input#ask
     * @return напечатанную пользователем строку в консоли
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Реализация метода для общения с пользователем в консоли
     * @param question вопрос пользователю
     * @param range массив возможных ответов
     * @see Input#ask
     * @return Возвращает значение введенное пользователем в консоль,
     * если оно находится в допустимом диапазоне числе, иначе метод вернет -1.
     */
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range. Please, select valid paragraph of menu.");
        }
    }
}
package tracker;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * @see tracker.ConsoleInput
 * Класс реализует ввод данных с консоли с валидацией
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Реализация метода для общения с пользователем в консоли
     * @param question вопрос пользователю
     * @param range массив возможных ответов
     * @see Input#ask(String, int[])
     * @return Возвращает значение введенное пользователем в консоль.
     * @throws MenuOutException если пользователь ввел число, которое отсутствует в массиве range[]
     * @throws NumberFormatException если пользователь ввел не число
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int userInputValue = -1;
        do {
            try {
                userInputValue = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Out of menu range. Please, select valid paragraph of menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("You enter not a number. Please, enter valid paragraph of menu.");
            }
        }
        while (invalid);
        return userInputValue;
    }
}
package tracker;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * @see tracker.ConsoleInput
 * Класс реализует ввод данных с консоли с валидацией
 */
public class ValidateInput implements Input {
    /**
     * Ввод данных
     */
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Реализация метода для общения с пользователем в консоли
     * @param question вопрос пользователю
     * @see Input#ask
     * @return напечатанную пользователем строку в консоли
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

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
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Out of menu range. Please, select valid paragraph of menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("You enter not a number. Please, enter valid paragraph of menu.");
            }
        } while (invalid);
        return  value;
    }
}
package tracker;

import java.util.Arrays;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс описывает сущность трекер.
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;


    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return Добавленная заявка в трекер
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальдый id для заявки
     * на основании текущей даты и случайного числа
     *
     * @return Уникальный id заявки
     */
    private String generateId() {
        long time = System.currentTimeMillis();
        long rnd = (long) (Math.random() * time);
        return String.valueOf(rnd);
    }

    /**
     * Метод реализует замену заявки в трекере
     *
     * @param id   Id заявки, которую нужно заменить
     * @param item Заявка, которую добавляем в трекер в замен другой заявки
     * @return True, если элемент для замены найден. В противном случае - false
     */
    public boolean replace(String id, Item item) {
        int index = 0;
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(id);
                items[index] = item;
                result = true;
                break;
            }
        }

        return result;
    }
    /**
     * Метод реализующий заявки из хранилища
     * @param id Id заявки, которую нужно удалить
     * @return True, если элемент для удаления найден. В противном случае - false
     */
    public boolean delete(String id) {
        boolean result = false;
        int index;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                index = i;
                System.arraycopy(items, index + 1, items, index, items.length - position - 1);
                position--;
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Метод реализует поиск всех заявок в трекере
     *
     * @return Возвращает массив всех заявок
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        System.arraycopy(items, 0, result, 0, position);
        return result;
    }

    /**
     * Метод реализует поиск заявки в трекере по ее имени
     *
     * @param key Имя заявки
     * @return Массив найденных заявок
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int resultPosition = 0;
        int cellIndex = 0;
        for (int i = 0; i < position; i++) {
            if (key.equals(this.items[i].getName())) {
                result[cellIndex++] = items[i];
                resultPosition++;
            }
        }
        result = Arrays.copyOf(result, resultPosition);
        return result;
    }

    /**
     * Метод реализует поиск заявки в трекере по id
     *
     * @param id Id заявки, которую ищем
     * @return Найденная заявка
     */
    public Item findById(String id) {
        Item result = new Item();
        for (Item item : items) {
            if (id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }
}
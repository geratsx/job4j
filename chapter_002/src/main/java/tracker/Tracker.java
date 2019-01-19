package tracker;

import java.util.ArrayList;
import java.util.List;

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
    private final List<Item> items = new ArrayList<>(100);
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
        this.items.add(this.position++, item);
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
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(id);
                items.set(i, item);
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
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод реализует поиск заявки в трекере по ее имени
     *
     * @param key Имя заявки
     * @return Массив найденных заявок
     */
    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>(position);
        for (int i = 0; i < position; i++) {
            if (key.equals(this.items.get(i).getName())) {
                result.add(items.get(i));
            }
        }
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

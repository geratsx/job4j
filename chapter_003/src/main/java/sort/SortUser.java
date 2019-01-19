package sort;

import java.util.*;
/**
 * Класс реализует различные сортировки пользователей.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    /**
     * Метод сортирует пользователей по возрасту путем вставки их в TreeSet.
     * @see User#compareTo(User)
     *
     * @param list Лист пользователей для сортировки
     * @return TreeSet содержащий пользователей из переданного методу листа.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
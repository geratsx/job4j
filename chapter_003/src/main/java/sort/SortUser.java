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
     *
     * @param list Лист пользователей для сортировки
     * @return TreeSet содержащий пользователей из переданного методу листа.
     * @see User#compareTo(User)
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * Метод сортирует пользователей по длине имени с помощью компоратора.
     *
     * @param list Лист пользователей для сортировки
     * @return Отсортированный List содержащий пользователей из переданного методу листа.
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> result = list;
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return result;
    }

    /**
     * Метод сортирует пользователей по имени и возрасту с помощью компоратора.
     *
     * @param list Лист пользователей для сортировки
     * @return Отсортированный LIst содержащий пользователей из переданного методу листа.
     * @see User#compareTo(User)
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> result = list;
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compareNames = o1.getName().compareTo(o2.getName());
                return compareNames != 0 ? compareNames : o1.getAge() - o2.getAge();
            }
        });
        return result;
    }
}
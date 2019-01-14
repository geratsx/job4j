package convert;

import java.util.HashMap;
import java.util.List;

/**
 * Класс реализует конвертер List user'ов в map.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {

    /**
     * Метод конвертирует List user'ов в map..
     *
     * @param list Коллекция, которую нужно конвертировать.
     * @return Map из элементов исходной коллекции.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
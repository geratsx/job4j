package ru.job4j.tourist;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс показывает применение stream api на примере профилей клиентов и адресов.
 **/
public class Profiles {
    /**
     * Метод позволяет получить список адресов клиентов из списка их профилей.
     * @param profiles Коллекция профилей для отбора.
     * @return Лист адресов, полученный в результате отбора.
     **/
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
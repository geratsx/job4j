package ru.job4j.tourist;

import java.util.Arrays;
import java.util.Comparator;
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

    /**
     * Метод позволяет получить список адресов клиентов из списка их профилей в отосртированном по городу порядке.
     * @param profiles Коллекция профилей для отбора.
     * @return Лист адресов, полученный в результате отбора.
     **/
     List<Address> getSortedByCityUniqueAddressList(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Address address1 = new Address("Moscow", "Leninskaya", 5, 110);
        Address address2 = new Address("Moscow", "Leninskaya", 5, 110);
        Address address3 = new Address("Kazan", "Lermontovskaya", 123, 56);

        List<Profile> profiles = Arrays.asList(new Profile(address1), new Profile(address2), new Profile(address3));

        Profiles pr = new Profiles();

        List<Address> addresses =  pr.getSortedByCityUniqueAddressList(profiles);

        addresses.forEach(System.out::println);
    }
}
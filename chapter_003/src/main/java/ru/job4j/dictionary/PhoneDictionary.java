package ru.job4j.dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует сущность телефонный справочник.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

    /**
     * Добаление человека в телефонный справочник.
     *
     * @param person человек, которого мы добаляем.
     */
    public void add(Person person) {
        this.persons.add(person);
    }


    /**
     * Метод позоляет найти  спраочнике человека по ключевому полю.
     * Поиск регистронезависимый по всем полям.
     *
     * @param key ключевое слово, по которому осущестляется поиск.
     * @return коллекция найденных людей в справочнике
     */
    public List<Person> find(String key) {
        String lowerKey = key.toLowerCase();
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().toLowerCase().contains(lowerKey) || person.getSurname().toLowerCase().contains(lowerKey)
                    || person.getAdress().toLowerCase().contains(lowerKey) || person.getPhone().toLowerCase().contains(lowerKey)) {
                result.add(person);
            }
        }
        return result;
    }
}
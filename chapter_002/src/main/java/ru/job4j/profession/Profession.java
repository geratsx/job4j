package ru.job4j.profession;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Класс описывает сущность профессия
 *
 */
public class Profession {


    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    private String name;
    private String profession;
}
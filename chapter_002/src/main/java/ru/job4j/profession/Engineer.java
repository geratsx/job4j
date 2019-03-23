package ru.job4j.profession;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс описывает сущность инженер.
 */
public class Engineer extends Profession {

    private String name;

    public Engineer(String name, String profession) {
        super(name, profession);
    }

    /**
     * Строит дом.
     *
     * @param house дом
     */
    private void buildHouse(House house) {

    }
}
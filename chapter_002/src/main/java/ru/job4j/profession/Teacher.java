package ru.job4j.profession;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Класс описывает сущность учитель
 */
public class Teacher extends Profession {

    private String name;

    public Teacher(String name, String profession) {
        super(name, profession);
        this.name = name;
    }

    /**
     * Учит студента.
     *
     * @param student студент
     */
    private void teachStudent(Student student) {

    }
}
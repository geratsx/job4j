package ru.job4j.profession;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс описывает сущность доктор.
 */
public class Doctor extends Profession {


    private String name;

    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Лечит пациента.
     *
     * @param  patient - пациент
     */
    private void treatPatient(Patient patient) {

    }
}
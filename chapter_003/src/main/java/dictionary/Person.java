package dictionary;

/**
 * Класс реализует сущность человек
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Person {

    private String name;
    private String surname;
    private String adress;
    private String phone;

    public Person(String name, String surname, String adress, String phone) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='"
                + name
                + '\''
                + ", surname='" + surname
                + '\''
                + ", adress='" + adress
                + '\''
                + ", phone='"
                + phone
                + '\''
                + '}';
    }
}
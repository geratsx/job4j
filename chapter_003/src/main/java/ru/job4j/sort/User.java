package ru.job4j.sort;

/**
 * Класс реализует сущность пользователь.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод служит для сравнения пользователей при сортировке по их возврасту .
     *
     * @param user другой пользователь, которого сравниваем с текущим.
     * @return Возвращает 0 если возраст равен и пользователи равны.
     * Если значение больше 0, то текущий пользователь больше.
     * Если значение меньше 0, то больше пользователь, который передан в метод.
     */
    @Override
    public int compareTo(User user) {
        return this.getAge() - user.getAge();
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age="
                + age
                + '}';
    }
}
package ru.job4j.bank;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс реализует сущность - банковский счет.
 */
public class Account {

    /**
     * Сумма на счете
     */
    private double value;
    /**
     * Номер счета
     */
    private String requesites;


    public Account(int value, String requesites) {
        this.value = value;
        this.requesites = requesites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequesites() {
        return requesites;
    }


    /**
     * Метод проверяет достаточно ли денег на счете для осуществления перевода.
     *
     * @param transferAmount Сумма, которую отправитель хочет перевести.
     * @return true, если для перевода достаточно денег, в противном случае false.
     */
    public boolean haveMoney(double transferAmount) {
        boolean success = false;
        if (this.value >= transferAmount) {
            success = true;
        }
        return success;
    }
}
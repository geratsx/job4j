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
     * Метод проверяет достаточно ли денег на счете для осуществления перевода
     * и осуществляет перевод.
     *
     * @param destAccount Счет на который нужно перевести деньги
     * @param transferAmount Сумма, которую отправитель хочет перевести.
     * @return true, если для перевод денег произведен, в противном случае false.
     */
    public boolean refillAccount(Account destAccount, double transferAmount) {
        boolean success = false;
        if (destAccount != null && this.value >= transferAmount) {
            this.value -= transferAmount;
            destAccount.value += transferAmount;
            success = true;
        }
        return success;
    }
}
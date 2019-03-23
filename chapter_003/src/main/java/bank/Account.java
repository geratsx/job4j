package bank;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс реализует сущность - банковский счет.
 */
public class Account {

    /**
     Сумма на счете
     */
    private double value;
    /**
     Номер счета
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

    public void setRequesites(String requesites) {
        this.requesites = requesites;
    }
}
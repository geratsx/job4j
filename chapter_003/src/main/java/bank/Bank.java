package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс реализует сущность - банк. Хранит в себе всех пользователей и их счета.
 * Реализует функционал перевода денег.
 */
public class Bank {

    /**
     * Карта хранит связку клиент - все счета клиента
     */
    private Map<User, List<Account>> accounts = new HashMap<>();

    /**
     * Метод реализует добавление нового пользователя.
     *
     * @param user Новый пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        List<Account> users = new ArrayList<>();
        accounts.putIfAbsent(user, users);
    }

    /**
     * Метод реализует удаление пользователя.
     *
     * @param user Пользователь, которого нужно удалить.
     */
    public void deleteUser(User user) {
        accounts.remove(user);
    }

    /**
     * Метод реализует добавление нового счета пользователю.
     *
     * @param account  Новый счет, который нужно добавить.
     * @param passport Паспортные данные клиента, которому нужно добавить счет.
     */
    public void addAccountToUser(String passport, Account account) {
        accounts.get(getUser(passport)).add(account);
    }

    /**
     * Метод реализует удаление счета пользователя.
     *
     * @param account  Счет, который нужно удалить.
     * @param passport Паспортные данные клиента, которому нужно удалить счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        accounts.get(getUser(passport)).remove(account);
    }

    /**
     * Метод реализует получение всех счетов пользователя по паспортным данным.
     *
     * @param passport Паспортные данные клиента, счета которого нужно получить.
     * @return Возвращает лист счетов клиента
     */
    public List<Account> getUserAccounts(String passport) {
        return accounts.get(this.getUser(passport));
    }

    /**
     * Метод реализует получение пользователя по паспортным данным.
     *
     * @param passport Паспортные данные клиента.
     * @return Возвращает найденногог клиента.
     */
    public User getUser(String passport) {
        User result = new User();
        for (Map.Entry<User, List<Account>> entry : accounts.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализует получение счета клиента клиента из коллекции по индексу.
     *
     * @param user  Клиент, счет которого нужно получить.
     * @param index Индекс счета в коллекции.
     * @return Счет клиента.
     * @throws ArrayIndexOutOfBoundsException в случае, если в коллекции нет такого индекса.
     */
    public Account getAccountByUserFromAccountList(User user, int index) throws ArrayIndexOutOfBoundsException {
        return this.accounts.get(user).get(index);
    }

    /**
     * Метод реализует перевод денег между счетами.
     * Перевод может быть не успешен если на счете списания недостаточно денег, или у пользователя нет такого счета(если индекс счета в коллекции = -1). {@link Bank#getAccountIndexByRequesites}
     *
     * @param srcPassport    Паспортные данные клиента, со счета которого нужно перевести деньги.
     * @param srcRequesites  Реквизиты счета, с которого нужно перевести деньги.
     * @param destPassport   Паспортные данные клиента, на счет которого нужно перевести деньги.
     * @param destRequesites Реквизиты счета, на который нужно перевести деньги.
     * @param amount         Сумма денег, которую нужног перевести.
     * @return True, если перевод успешен и false, если перевод не успешен.
     */
    public boolean transferMoney(String srcPassport, String srcRequesites, String destPassport, String destRequesites, double amount) {
        boolean success = true;
        User srcUser = getUser(srcPassport);
        User destUser = getUser(destPassport);
        int srcAccountIndex = getAccountIndexByRequesites(srcRequesites);
        int destAccountIndex = getAccountIndexByRequesites(destRequesites);
        try {
            Account srcAccount = getAccountByUserFromAccountList(srcUser, srcAccountIndex);
            if (srcAccountIndex >= 0 && destAccountIndex >= 0 && srcAccount.getValue() >= amount) {
                Account destAccount = getAccountByUserFromAccountList(destUser, destAccountIndex);
                srcAccount.setValue(srcAccount.getValue() - amount);
                destAccount.setValue(destAccount.getValue() + amount);
            } else {
                success = false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            success = false;
        }
        return success;
    }

    /**
     * Метод реализует получение индекса, под которым в коллекции лежит счет клиента, по реквизитам счета.
     *
     * @param requesites Реквизиты счета, индекс которого нужно получить.
     * @return Индекс искомого счета в коллекции. Если такого счета у клиента нет - возвращает -1.
     */
    public int getAccountIndexByRequesites(String requesites) {
        int result = -1;
        for (List<Account> list : accounts.values()) {
            for (Account account : list) {
                if (requesites.equals(account.getRequesites())) {
                    result = list.lastIndexOf(account);
                    break;
                }
            }
        }
        return result;
    }

    public Map<User, List<Account>> getAccounts() {
        return accounts;
    }
}

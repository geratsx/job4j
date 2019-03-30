package ru.job4j.bank;

import java.util.*;

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

    public Map<User, List<Account>> getAccounts() {
        return accounts;
    }

    /**
     * Метод реализует добавление нового клиента.
     *
     * @param user Новый пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        List<Account> accountList = new ArrayList<>();
        accounts.putIfAbsent(user, accountList);
    }

    /**
     * Метод реализует удаление клиента,
     * если такой клиент есть {@link Bank#getUser(String)}.
     *
     * @param user Клиент, которого нужно удалить.
     * @return true, если клиент удален, в противном случае возвращает false.
     */
    public boolean deleteUser(User user) {
        boolean result = getUser(user.getPassport()).isPresent();
        if (result) {
            accounts.remove(user);
        }
        return result;
    }

    /**
     * Метод реализует добавление нового счета клиенту.
     *
     * @param passport Паспортные данные клиента, которому нужно добавить счет.
     * @param account  Новый счет, который нужно добавить.
     * @return true, если такой клиент есть и счет успешно добавлен, в противном случае возвращает false {@link Bank#getUser(String)}.
     */
    public boolean addAccountToUser(String passport, Account account) {
        boolean result = false;
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            accounts.get(user.get()).add(account);
            result = true;
        }
        return result;
    }

    /**
     * Метод реализует удаление счета клиента.
     *
     * @param passport Паспортные данные клиента, счет которого нужно удалить.
     * @param account  Счет, который нужно удалить.
     * @return true, если такой клиент есть и счет успешно удален, в противном случае возвращает false {@link Bank#getUser(String)}.
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        boolean result = false;
        Optional<User> userCandidate = getUser(passport);
        if (userCandidate.isPresent()) {
            Optional<Account> accountCandidate = getAccountByRequesites(account.getRequesites());
            if (accountCandidate.isPresent()) {
                accounts.get(userCandidate.get()).remove(account);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод реализует получение всех счетов пользователя по паспортным данным.
     *
     * @param passport Паспортные данные клиента, счета которого нужно получить.
     * @return Возвращает лист счетов клиента. Если такого пользователя нет {@link Bank#getUser(String)}, то вернет пустую лист.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            result = accounts.get(user.get());
        }
        return result;
    }

    /**
     * Метод реализует получение клиента по паспортным данным.
     *
     * @param passport Паспортные данные клиента.
     * @return Возвращает Optional<User>. При использовании результата вызова метода нужно проверить, что в Optional<User> есть клиент - {@link Optional#isPresent()}.
     */
    public Optional<User> getUser(String passport) {
        return accounts.entrySet().stream().map(Map.Entry::getKey).filter(user -> user.getPassport().equals(passport)).findFirst();
    }

    /**
     * Метод реализует перевод денег между счетами.
     * Перевод может быть не успешен если:
     * 1) Не существует хотя бы одного из клиентов. Для этого проверяем результат вызова {@link Bank#getUser(String)} с помощью  {@link Optional#isPresent()}.
     * 2) Не существует хотя бы одного из счетов, между которыми переводятся деньги. Для этого проверяем результат вызова {@link Bank#getAccountByRequesites(String)} с помощью  {@link Optional#isPresent()}.
     * 3) На счете отправителя не достаточно денег {@link Account#haveMoney(double)}.
     *
     * @param srcPassport    Паспортные данные клиента, со счета которого нужно перевести деньги.
     * @param srcRequesites  Реквизиты счета, с которого нужно перевести деньги.
     * @param destPassport   Паспортные данные клиента, на счет которого нужно перевести деньги.
     * @param destRequesites Реквизиты счета, на который нужно перевести деньги.
     * @param amount         Сумма денег, которую нужног перевести.
     * @return true, если перевод успешен, в противном случае вренет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequesites, String destPassport, String destRequesites, double amount) {
        boolean success = false;
        Optional<User> srcUserCandidate = getUser(srcPassport);
        Optional<User> destUserCandidate = getUser(destPassport);
        if (srcUserCandidate.isPresent() && destUserCandidate.isPresent()) {
            Optional<Account> srcAccountCandidate = getAccountByPassportAndRequesites(srcPassport, srcRequesites);
            Optional<Account> destAccountCandidate = getAccountByPassportAndRequesites(destPassport, destRequesites);
            if (srcAccountCandidate.isPresent() && destAccountCandidate.isPresent()) {
                if (srcAccountCandidate.get().haveMoney(amount)) {
                    srcAccountCandidate.get().setValue(srcAccountCandidate.get().getValue() - amount);
                    destAccountCandidate.get().setValue(destAccountCandidate.get().getValue() + amount);
                    success = true;
                }
            }
        }
        return success;
    }

    /**
     * Метод реализует получение счета клиента по паспорту клиента и реквизитам.
     *
     * @param passport   Паспортные данные клиента, счет которого нужно получить.
     * @param requesites Реквизиты счета, который нужно получить.
     * @return Optional<Account>. Если аккаунта нет, возвращает пустой объект.
     */
    public Optional<Account> getAccountByPassportAndRequesites(String passport, String requesites) {
        Optional<Account> account = Optional.empty();
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            account = getAccountByRequesites(requesites);
        }
        return account;
    }

    /**
     * Метод реализует получение клиента по паспортным данным.
     *
     * @param requesites Реквизиты искомого счета.
     * @return Возвращает найденный счет клиента в виде - Optional<Account>.
     * При использовании результата вызова метода нужно проверить, что в Optional<Account> есть клиент - {@link Optional#isPresent()}
     */

    public Optional<Account> getAccountByRequesites(String requesites) {
        return accounts.values().stream().flatMap(Collection::stream).filter(account -> account.getRequesites().equals(requesites)).findFirst();
    }
}

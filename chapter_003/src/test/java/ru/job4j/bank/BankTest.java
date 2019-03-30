package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenUserAddedThenHiIsInBank() {
        Bank bank = new Bank();
        User expect = new User("Vasya", "12345");
        bank.addUser(expect);
        assertTrue(bank.getAccounts().containsKey(expect));
    }

    @Test
    public void whenUserDeletedThenHeIsNotInBank() {
        Bank bank = new Bank();
        User user1 = new User("Petya", "55555");
        User user2 = new User("Vasya", "12345");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        assertFalse(bank.getAccounts().containsKey(user1));
    }

    @Test
    public void whenNoUserThenDeletedFailed() {
        Bank bank = new Bank();
        User user1 = new User("Petya", "55555");
        User user2 = new User("Vasya", "12345");
        bank.addUser(user2);
        assertFalse(bank.deleteUser(user1));
    }

    @Test
    public void whenAccountAddedThenItInBank() {
        Bank bank = new Bank();
        User user = new User("Petya", "55555");
        Account expect = new Account(5000, "408107");
        bank.addUser(user);
        bank.addAccountToUser("55555", expect);
        assertTrue(bank.getAccounts().get(user).contains(expect));
    }

    @Test
    public void whenAccountAddedButNoUserThenFalse() {
        Bank bank = new Bank();
        Account account = new Account(5000, "408107");
        assertFalse(bank.addAccountToUser("55555", account));
    }

    @Test
    public void whenAccountDeletedThenItNotInBank() {
        Bank bank = new Bank();
        User user = new User("Petya", "55555");
        Account expect = new Account(5000, "408107");
        bank.addUser(user);
        bank.addAccountToUser("55555", expect);
        assertTrue(bank.deleteAccountFromUser("55555", expect));
    }


    @Test
    public void whenGetUserThenReturnThisUser() {
        Bank bank = new Bank();
        User expect = new User("Petya", "55555");
        bank.addUser(expect);
        User result = bank.getUser("55555").get();
        assertEquals(expect, result);
    }

    @Test
    public void whenGetAccountThenReturnAccount() {
        Bank bank = new Bank();
        User user = new User("Petya", "55555");
        bank.addUser(user);
        Account expect = new Account(5000, "408107");
        bank.addAccountToUser("55555", expect);
        Account result = bank.getAccountByRequesites("408107").get();
        assertEquals(expect, result);
    }

    @Test
    public void whenTransferMoneyThenTransferedToRecipientsAccount() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(5000, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.transferMoney(user1.getPassport(), account1.getRequesites(),
                user2.getPassport(), account2.getRequesites(), 1000.00);
        double expect = 1400;
        double result = account2.getValue();
        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferMoneyThenTransferedFromSendersAccount() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(5000, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.transferMoney(user1.getPassport(), account1.getRequesites(),
                user2.getPassport(), account2.getRequesites(), 1000.00);
        double expect = 4000;
        double result = account1.getValue();
        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferMoneyAndNoMoneyThenTransferNotSuccessful() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(0, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        assertFalse(bank.transferMoney(user1.getPassport(), account1.getRequesites(),
                user2.getPassport(), account2.getRequesites(), 1000.00));
    }

    @Test
    public void whenTransferMoneyAndNoDestinationAccountThenTransferNotSuccessful() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(0, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        assertFalse(bank.transferMoney(user1.getPassport(), account1.getRequesites(),
                user2.getPassport(), account2.getRequesites(), 1000.00));
    }

    @Test
    public void whenTransferMoneyAndNoSourceAccountThenTransferNotSuccessful() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(0, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user2.getPassport(), account2);
        assertFalse(bank.transferMoney(user1.getPassport(), account1.getRequesites(),
                user2.getPassport(), account2.getRequesites(), 1000.00));
    }

    @Test
    public void whenHavePassportThenHaveAllUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Vasya", "12345");
        Account account1 = new Account(0, "408107");
        Account account2 = new Account(400, "308107");
        List<Account> expect = Arrays.asList(account1, account2);
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account1);
        bank.addAccountToUser(user.getPassport(), account2);
        List<Account> result = bank.getUserAccounts(user.getPassport());
        assertThat(expect, is(result));
    }

    @Test
    public void whenHaveMoneyThenSuccsess() {
        Bank bank = new Bank();
        assertTrue(bank.haveMoney(1000, 500));
    }

    @Test
    public void whenNoMoneyThenUnsuccsess() {
        Bank bank = new Bank();
        assertFalse(bank.haveMoney(1000, 5000));
    }
}
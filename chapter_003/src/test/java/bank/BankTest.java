package bank;

import org.junit.Test;

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
        User user2 = new User("Petya", "55555");
        User user1 = new User("Vasya", "12345");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        assertFalse(bank.getAccounts().containsKey(user1));
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
    public void whenAccountDeletedThenItNotInBank() {
        Bank bank = new Bank();
        User user = new User("Petya", "55555");
        Account expect = new Account(5000, "408107");
        bank.addUser(user);
        bank.addAccountToUser("55555", expect);
        bank.deleteAccountFromUser("55555", expect);
        assertFalse(bank.getAccounts().get(user).contains(expect));
    }


    @Test
    public void whenGetUserThenReturnUser() {
        Bank bank = new Bank();
        User expect = new User("Petya", "55555");
        bank.addUser(expect);
        User result = bank.getUser("55555");
        assertEquals(expect, result);
    }

    @Test
    public void whenGetAccountThenReturnAccount() {
        Bank bank = new Bank();
        User user = new User("Petya", "55555");
        bank.addUser(user);
        Account expect = new Account(5000, "408107");
        bank.addAccountToUser("55555", expect);
        Account result = bank.getAccountByUserFromAccountList(user, 0);
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
    public void whenHaveRequesitsThenGetAccountIndex() {
        Bank bank = new Bank();
        User user1 = new User("Vasya", "12345");
        User user2 = new User("Petya", "55555");
        Account account1 = new Account(1000, "408107");
        Account account2 = new Account(400, "308107");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        int expected = 0;
        int result = bank.getAccountIndexByRequesites("408107");
        assertEquals(expected, result);
    }
}
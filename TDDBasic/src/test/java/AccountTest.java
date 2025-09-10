import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp(){
        account = new Account(10000);
    }

    @Test
    void createAccountWithDeposit(){
        assertEquals(10000, account.getBalance());
    }

    @Test
    void createAccountWithNoDeposit(){
        Account account = new Account(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void deposit(){
        assertEquals(10000, account.getBalance());
        account.deposit(2000);
        assertEquals(12000, account.getBalance());
    }

    @Test
    void withdraw(){
        assertEquals(10000, account.getBalance());
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

    @Test
    void withdrawBigMoney(){
        assertEquals(10000, account.getBalance());
        account.withdraw(100000);
        assertEquals(0, account.getBalance());
    }
}

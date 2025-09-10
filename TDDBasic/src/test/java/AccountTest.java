import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100000));
    }

    @Test
    void sendToOther(){
        Account otherAccount = new Account(10000);
        assertEquals(10000, otherAccount.getBalance());

        // 송금하기
        otherAccount.sendTo(account, 10000);


        // 송금 받았는지 확인
        assertEquals(20000, account.getBalance());
    }

    @Test
    void sendToOtherBigMoney(){
        Account otherAccount = new Account(10000);
        assertEquals(10000, otherAccount.getBalance());

        // 송금하기
        Exception e = assertThrows(IllegalArgumentException.class, () -> account.sendTo(otherAccount, 50000));
        assertEquals("잔액이 부족합니다.", e.getMessage());


        // 송금 받았는지 확인
        assertEquals(10000, account.getBalance());
    }

    @Test
    void testInterest(){
        account.interest();
        assertEquals(10500, account.getBalance());
    }

    @Test
    void setInterset(){
        assertNotNull(account.interest);
        assertEquals(5, account.interest);
        account.setInterest(10);
        assertEquals(10, account.interest);
    }

    @Test
    void testSettingInterest(){
        assertNotNull(account.interest);
        account.setInterest(10);
        assertEquals(10, account.interest);
        account.interest();
        assertEquals(11000, account.getBalance());
    }

    @Test
    void testYearsInterest(){
        assertNotNull(account.interest);
        account.interest(2);
        assertEquals(11025, account.getBalance());
    }
}

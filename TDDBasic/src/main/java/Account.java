public class Account {
    public int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int deposit) {
        this.balance += deposit;
    }

    public void withdraw(int money) {
        if( money > this.balance){
            this.balance = 0;
        }else{
            this.balance -= money;
        }

    }
}

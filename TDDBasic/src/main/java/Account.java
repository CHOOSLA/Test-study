public class Account {
    public int balance;
    public int interest = 5;

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
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }else{
            this.balance -= money;
        }
    }

    public void sendTo(Account otherAccount, int money) {
        if( money > this.balance){
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }

        withdraw(money);
        otherAccount.deposit(money);
    }

    public void interest() {
        balance = balance + (int)(balance * ((double)interest / 100.0));
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public void interest(int year){
        for(int i=0; i < year; i++){
            interest();
        }
    }
}

public class Account {
    String accountNumber;
    String accountType;
    Double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(String accountType, Double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    Double deposit(Double amount){
        this.balance+=amount;
        return this.balance;
    }
    Double withdraw(Double amount){
        if(balance<amount+2000){
            //System.out.println("Insufficient funds");
            return null;
        }
        this.balance-=amount;
        return this.balance;

    }
    Double transfer(Account src,Account target,Double amount){
        if(src.balance<amount+2000){
            //System.out.println("Insufficient funds");
            return null;
        }
        src.balance-=amount;
        target.balance+=amount;
        return amount;
    }


}
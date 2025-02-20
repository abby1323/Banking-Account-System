import java.util.List;

public class User {
    String userId;
    String name;
    String phoneNumber;
    List<Account> accountList;
    List<Transaction> transactionList;

    public User() {
    }

    public User(String name, String phoneNumber) {
        this.userId = generateUserId();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Account createAccount(User user, String accType, String amount) {
        Account account = new Account(accType,Double.parseDouble(amount));
        user.accountList.add(account);
        return account;
    }

    public static Account getAccount(User user2, String accNo) {

        List<Account> accountList1 = user2.accountList;
        for(Account account: accountList1){
            if(account.getAccountNumber().equalsIgnoreCase(accNo)){
                return account;
            }
        }

        return null;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    static User getUser(List<User> userList, String id){
        User user1 = null;
        for(User user : userList){
            if (user.getUserId().equals(id)){
                user1 = user;
            }
        }

        return user1;

    }

    String generateUserId(){
        return "";
    }


    String showUserDetails(){
        String display = "";
        display += "Name: " + this.getName() + "Customer ID: " + this.getUserId() + "Phone Number: " + this.getPhoneNumber();
        return display;

    }
    String showAccountDetails(){
        String display = "";
        for(Account account : this.accountList){
            display+="\nAccount Number: " + account.getAccountNumber()
                    + "\n Account Type: " + account.getAccountType()
                        + "\n Balance : " + account.getBalance() ;
        }
        return display;
    }

    String showLastNTransactions(Integer n){
        return "No recent transactions!";
    }
}
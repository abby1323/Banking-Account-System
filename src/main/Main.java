import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{

    public static void main(String[] args) {

        System.out.println("****Welcome to  ABBY BANK*****");

        System.out.println("What do you wish to do? ");

        System.out.println("Press 1 to create new Account : ");
        System.out.println("Press 2 to view Profile");
        System.out.println("Press 3 to view Account details");
        System.out.println("Press 4 to deposit money");
        System.out.println("Press 5 to withdraw money");
        System.out.println("Press 6 to transfer money");
        System.out.println("Press 7 to view last N transactions");
        System.out.println("Press 8 to exit");

        System.out.println("Enter command:");

        Scanner scanner = new Scanner(System.in);

        List<User> userList = new ArrayList<>();

        while(true){
            System.out.println("What do you wish to do? ");

            System.out.println("Press 1 to create new Account : ");
            System.out.println("Press 2 to view Profile");
            System.out.println("Press 3 to view Account details");
            System.out.println("Press 4 to deposit money");
            System.out.println("Press 5 to withdraw money");
            System.out.println("Press 6 to transfer money");
            System.out.println("Press 7 to view last N transactions");
            System.out.println("Press 8 to exit");
            String cmd = scanner.next();

            switch(cmd){
                case "1":
                    // create new account
                    //input customer ID
                    //check is user already exists
                    //if exists retrieve account list and add to it
                    //if does not exist create new user by taking all info then create new account

                    System.out.println("Press 1 if already registered\n Press 2 if new customer");
                    String cmd1 = scanner.next();
                    if("1".equals(cmd1)){
                        System.out.println("Enter customer ID");
                        String custId = scanner.next();
                        User user = User.getUser(userList,custId);
                        System.out.println("Enter Account Type: C for Current, S for Savings:");
                        String accType = scanner.next();
                        System.out.println("Enter initial amount to be deposited in bank\n Minimum balance is 2000");
                        String amount = scanner.next();
                        Account account = User.createAccount(user, accType, amount);
                        if(account!=null) {
                            System.out.println();
                        }else{
                            System.out.println("Please try again!");
                        }

                    } else if ("2".equals(cmd1)) {
                        System.out.println("Enter name");
                        String name = scanner.next();
                        System.out.println("Enter phone number");
                        String phoneNumber = scanner.next();
                        User user = new User(name,phoneNumber);
                        System.out.println("Enter Account Type: C for Current, S for Savings:");
                        String accType = scanner.next();
                        System.out.println("Enter initial amount to be deposited in bank\n Minimum balance is 2000");
                        String amount = scanner.next();
                        Account account = User.createAccount(user,accType,amount);
                        if(account!=null){
                            System.out.println("Account created successfully");
                        }else{
                            System.out.println("Please try again!");
                        }

                    }


                    break;
                case "2":
                    //view profile
                    //input customer ID
                    //show profile details

                    System.out.println("Enter customer ID");
                    String custId = scanner.next();
                    User user = User.getUser(userList,custId);
                    System.out.println(user.showUserDetails());
                    break;
                case "3":
                    //view account details
                    //input customer ID
                    //show account details
                    System.out.println("Enter customer ID");
                    String custId1 = scanner.next();
                    User user1 = User.getUser(userList,custId1);
                    System.out.println(user1.showAccountDetails());
                    break;
                case "4":
                    //deposit money
                    //input customer ID
                    // input deposit amount
                    //call method , show success msg
                    System.out.println("Enter customer ID");
                    String custId2 = scanner.next();
                    User user2 = User.getUser(userList,custId2);
                    System.out.println("Select Account from : ");
                    System.out.println(user2.showAccountDetails());
                    String accNo = scanner.next();
                    System.out.println("Enter amount to be deposited : ");
                    String amount = scanner.next();
                    Account account = User.getAccount(user2,accNo);
                    if(account!=null) {
                        account.deposit(Double.parseDouble(amount));
                    }else{
                        System.out.println("No such account exists... Please try again");
                    }

                    break;
                case "5":
                    // withdraw money
                    // input customer ID
                    // input withdraw amount
                    //call method, show msg
                    System.out.println("Enter customer ID");
                    String custId3 = scanner.next();
                    User user3 = User.getUser(userList,custId3);
                    System.out.println("Select Account from : ");
                    System.out.println(user3.showAccountDetails());
                    String accNo1 = scanner.next();
                    System.out.println("Enter amount to be deposited : ");
                    String amount1 = scanner.next();
                    Account account1 = User.getAccount(user3,accNo1);
                    if(account1!=null) {
                        account1.deposit(Double.parseDouble(amount1));
                    }else{
                        System.out.println("No such account exists... Please try again");
                    }
                    break;
                case "6":
                    //transfer money
                    //input customer ID
                    //input src & target account Numbers
                    //call method, show msg
                    System.out.println("Enter customer ID");
                    String custId4 = scanner.next();
                    User user4 = User.getUser(userList,custId4);
                    System.out.println("Select Account from : ");
                    System.out.println(user4.showAccountDetails());
                    String accNo2 = scanner.next();
                    Account account2 = User.getAccount(user4,accNo2);
                    System.out.println("Enter amount to be transferred : ");
                    String amount2 = scanner.next();
                    System.out.println("Enter account number of payee: ");
                    String accNo3 = scanner.next();
                    Account account3 = User.getAccount(user4,accNo3);
                    account2.transfer(account2,account3,Double.parseDouble(amount2));
                case "7":
                    //view last N transactions
                    // input cutomer ID
                    // input "N"
                    // call method, print transactions
                    System.out.println("Enter customer ID");
                    String custId5 = scanner.next();
                    User user5 = User.getUser(userList,custId5);
                    System.out.println("Enter how many last transactions you wish to view: ");
                    Integer n = scanner.nextInt();
                    System.out.println(user5.showLastNTransactions(n));


                case "8":
                    //exit from system
                    System.out.println("Thank you for banking with Abby Bank...Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid cmd, try again");
                    break;

            }
        }


    }
}
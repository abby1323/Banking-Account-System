import java.util.Date;

public class Transaction {
    Long transactionId;
    String transactionType;
    Double amount;
    String fromAccount;
    String toAccount;

    Date date;

    String displayLastNTransactions(Integer n){
        return "No recent transactions!";
    }
}
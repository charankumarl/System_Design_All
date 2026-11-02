package LowLevelDesign.Design_Payment_Gateway.Transaction;

import java.util.List;

public class TransactionController {

    TransactionService service = new TransactionService();

    public void makePayment(Transaction transaction){
        service.makePayment(transaction);
    }

    public List<Transaction> getHistory(int userId){
        return service.getHistory(userId);
    }
}

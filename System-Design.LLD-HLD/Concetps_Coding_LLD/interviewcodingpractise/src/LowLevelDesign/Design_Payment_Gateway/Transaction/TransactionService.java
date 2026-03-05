package LowLevelDesign.Design_Payment_Gateway.Transaction;

import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentContrller;
import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentDo;
import LowLevelDesign.Design_Payment_Gateway.Processor;

import java.util.HashMap;
import java.util.*;

public class TransactionService {

    InstrumentContrller instrumentContrller;
    Processor processor = new Processor();

    Map<Integer, List<Transaction>> map = new HashMap<>();

    public void makePayment(Transaction transactionDo){

        processor.processPayment(transactionDo.amount, transactionDo.sender, transactionDo.receiver);
        Transaction transaction = new Transaction();

        transaction.id = new Random().nextInt(1000);
        transaction.amount = transactionDo.amount;
        transaction.sender = transactionDo.sender;
        transaction.receiver = transactionDo.receiver;
        transaction.status = "Success";

        if(map.containsKey(transactionDo.sender)){
            map.get(transactionDo.sender).add(transaction);
        }
        else{
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);
            map.put(transactionDo.sender, transactions);
        }
    }

    public List<Transaction> getHistory(int userId){
        return map.get(userId);
    }
}

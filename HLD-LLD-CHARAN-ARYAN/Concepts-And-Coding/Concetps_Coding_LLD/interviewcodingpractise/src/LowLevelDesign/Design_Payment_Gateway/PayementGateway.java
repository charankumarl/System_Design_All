package LowLevelDesign.Design_Payment_Gateway;

import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentContrller;
import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentDo;
import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentType;
import LowLevelDesign.Design_Payment_Gateway.Transaction.Transaction;
import LowLevelDesign.Design_Payment_Gateway.Transaction.TransactionController;
import LowLevelDesign.Design_Payment_Gateway.Transaction.TransactionDo;
import LowLevelDesign.Design_Payment_Gateway.User.UserController;
import LowLevelDesign.Design_Payment_Gateway.User.UserDo;

import java.util.List;

public class PayementGateway {

    TransactionController transactionController = new TransactionController();
    InstrumentContrller instrumentContrller = new InstrumentContrller();
    UserController userController = new UserController();

    public static void main(String[] args) {

        TransactionController transactionController = new TransactionController();
        InstrumentContrller instrumentContrller = new InstrumentContrller();
        UserController userController = new UserController();

        // Create a new user
        UserDo userDo = new UserDo();
        userDo.setUserId(1);
        userDo.setName("charan");
        userDo.setEmail("anc");
        userDo.setPhone("1234567890");

        UserDo userDo1 = new UserDo();
        userDo.setUserId(2);
        userDo.setName("kumar");
        userDo.setEmail("xyz");
        userDo.setPhone("0987654321");

        userController.addUser(userDo);
        userController.addUser(userDo1);

        // Create a new instrument

        InstrumentDo instrumentDo = new InstrumentDo();
        instrumentDo.setId(1);
        instrumentDo.setUserId(1);
        instrumentDo.setType(InstrumentType.BANK);
        instrumentDo.setAccNo("1234");
        instrumentDo.setCvv("1234");

        instrumentContrller.addInstrument(instrumentDo);

        InstrumentDo instrumentDo1 = new InstrumentDo();
        instrumentDo1.setId(2);
        instrumentDo1.setUserId(2);
        instrumentDo1.setType(InstrumentType.BANK);
        instrumentDo1.setAccNo("6789");
        instrumentDo1.setCvv("6789");

        instrumentContrller.addInstrument(instrumentDo1);

        userDo.instrument = instrumentDo;
        userDo1.instrument = instrumentDo1;

        // Create a new transaction
        Transaction transactionDo = new Transaction();
        transactionDo.setId(1);
        transactionDo.setSender(1);
        transactionDo.setReceiver(2);
        transactionDo.setAmount(1000);
        transactionDo.setType(InstrumentType.BANK);

        transactionController.makePayment(transactionDo);

        List<Transaction> transactions =  transactionController.getHistory(1);
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Sender: " + transaction.getSender());
            System.out.println("Receiver: " + transaction.getReceiver());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Status: " + transaction.getStatus());
            System.out.println();
        }
    }

}

package LowLevelDesign.Design_Payment_Gateway.Transaction;

import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentType;

public class TransactionDo {

    int id;
    int amount;
    int sender;
    int receiver;
    InstrumentType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public InstrumentType getType() {
        return type;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }
}

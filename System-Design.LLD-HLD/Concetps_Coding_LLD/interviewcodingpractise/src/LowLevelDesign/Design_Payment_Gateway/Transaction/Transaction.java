package LowLevelDesign.Design_Payment_Gateway.Transaction;

import LowLevelDesign.Design_Payment_Gateway.Instrument.Instrument;
import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentType;

public class Transaction {

    int id;
    int amount;
    int sender;
    int receiver;
    String status;
    InstrumentType instrument;

    public Transaction(int id, int amount, int sender, int receiver, String status, InstrumentType instrument) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public Transaction() {
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InstrumentType getType() {
        return instrument;
    }

    public void setType(InstrumentType instrument) {
        this.instrument = instrument;
    }
}

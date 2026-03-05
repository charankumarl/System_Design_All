package LowLevelDesign.Design_Payment_Gateway.Instrument;

public class InstrumentServiceFactory {

    public static InstrumentService getInstrumentService(InstrumentType instrumentType) {

        switch (instrumentType) {
            case CARD:
                return new CardService();
            case BANK:
                return new BankService();
            default:
                throw new IllegalArgumentException("Invalid instrument type: " + instrumentType);
        }
    }
}

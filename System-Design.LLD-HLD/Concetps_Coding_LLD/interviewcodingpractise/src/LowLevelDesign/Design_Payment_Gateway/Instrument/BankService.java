package LowLevelDesign.Design_Payment_Gateway.Instrument;

import java.util.*;
import java.util.zip.InflaterInputStream;

public class BankService extends InstrumentService{


    @Override
    public InstrumentDo addInstrument(InstrumentDo instrument) {

        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.id = new Random().nextInt();
        bankInstrument.userId = instrument.userId;
        bankInstrument.accNo = instrument.accNo;
        bankInstrument.ifsc = instrument.ifsc;
        bankInstrument.type = instrument.type;

        if(userToInstrumentMap.containsKey(bankInstrument.userId)){
            userToInstrumentMap.get(bankInstrument.userId).add(bankInstrument);
        }
        else{
            List<Instrument> instrumentList = new ArrayList<>();
            instrumentList.add(bankInstrument);
            userToInstrumentMap.put(bankInstrument.userId, instrumentList);
        }

        return mapToBankInstrumentDo(bankInstrument);
    }

    @Override
    public List<InstrumentDo> getInstrument(int userId) {

        if(!userToInstrumentMap.containsKey(userId)){
            return null;
        }

        List<Instrument> instrumentList = userToInstrumentMap.get(userId);
        if(instrumentList.size() == 0){
            return null;
        }

        List<InstrumentDo> instrumentDoList = new ArrayList<>();

        for(Instrument instrument1 : instrumentList){
            instrumentDoList.add(mapToBankInstrumentDo((BankInstrument) instrument1));
        }

        return instrumentDoList;
    }

    public InstrumentDo mapToBankInstrumentDo(BankInstrument instrument){

        InstrumentDo instrumentDo = new InstrumentDo();
        instrumentDo.id = instrument.id;
        instrumentDo.userId = instrument.userId;
        instrumentDo.accNo = instrument.accNo;
        instrumentDo.ifsc = instrument.ifsc;
        return instrumentDo;
    }
}

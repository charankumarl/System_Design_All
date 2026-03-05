package LowLevelDesign.Design_Payment_Gateway.Instrument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService{

    @Override
    public InstrumentDo addInstrument(InstrumentDo instrument) {

        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.id = new Random().nextInt(1000);
        cardInstrument.userId = instrument.userId;
        cardInstrument.cardNo = instrument.cardNo;
        cardInstrument.cvvNo = instrument.cvv;
        cardInstrument.type = instrument.type;

        if(userToInstrumentMap.containsKey(cardInstrument.userId)){
            userToInstrumentMap.get(cardInstrument.userId).add(cardInstrument);
        }
        else{
            List<Instrument> instrumentList = new ArrayList<>();
            instrumentList.add(cardInstrument);
            userToInstrumentMap.put(cardInstrument.userId, instrumentList);
        }

        return mapToCardInstrumentDo(cardInstrument);
    }

    @Override
    public List<InstrumentDo> getInstrument(int userId) {

        if(!userToInstrumentMap.containsKey(userId)){
            return Collections.emptyList();
        }

        List<Instrument> instrumentList = userToInstrumentMap.get(userId);
        if(instrumentList.size() == 0){
            return Collections.emptyList();
        }

        List<InstrumentDo> instrumentDoList = new ArrayList<>();

        for(Instrument instrument1 : instrumentList){
            instrumentDoList.add(mapToCardInstrumentDo((CardInstrument) instrument1));
        }

        return instrumentDoList;
    }

    public InstrumentDo mapToCardInstrumentDo(CardInstrument instrument){

        InstrumentDo instrumentDo = new InstrumentDo();
        instrumentDo.id = instrument.id;
        instrumentDo.userId = instrument.userId;
        instrumentDo.cardNo = instrument.cardNo;
        instrumentDo.cvv = instrument.cvvNo;
        return instrumentDo;
    }
}

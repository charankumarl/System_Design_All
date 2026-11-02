package LowLevelDesign.Design_Payment_Gateway.Instrument;

import java.util.List;

public class InstrumentContrller {

    InstrumentService service;

    public InstrumentDo addInstrument(InstrumentDo instrumentDo){
        service = InstrumentServiceFactory.getInstrumentService(instrumentDo.type);
        return service.addInstrument(instrumentDo);
    }

    public List<InstrumentDo> getInstrumentDo(InstrumentType type, int userId){
        service = InstrumentServiceFactory.getInstrumentService(type);
        return service.getInstrument(userId);
    }
}

package LowLevelDesign.Design_Payment_Gateway.Instrument;

import java.util.List;
import java.util.*;

public abstract class InstrumentService {

    Map<Integer, List<Instrument>> userToInstrumentMap = new HashMap<>();

    public abstract InstrumentDo addInstrument(InstrumentDo instrument);

    public abstract List<InstrumentDo> getInstrument(int userId);
}

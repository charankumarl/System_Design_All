package amountWithdrawl;

import CommonEnum.CashType;
import StatePattern.ATMContext.ATMMachineContext;
import UtilityClasses.ATMInventory;

import java.util.Map;

public abstract class AmountWithdraw_Processor {

    AmountWithdraw_Processor nextProcessor;

    public AmountWithdraw_Processor(AmountWithdraw_Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdrawAmount(Map<CashType, Integer> cashInventory, int amount, Map<CashType, Integer> dispensedCash){

        if(nextProcessor != null){
            nextProcessor.withdrawAmount(cashInventory, amount, dispensedCash);
        }
    }
}

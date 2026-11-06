package amountWithdrawl;

import CommonEnum.CashType;
import StatePattern.ATMContext.ATMMachineContext;
import UtilityClasses.ATMInventory;

import java.util.Map;

public class Two_Hundered_Processor extends AmountWithdraw_Processor{

    public Two_Hundered_Processor(AmountWithdraw_Processor nextProcessor) {
        super(nextProcessor);
    }

    public void withdrawAmount(Map<CashType, Integer> cashInventory, int amount, Map<CashType, Integer> dispensedCash){

        int remainingAmount = cashInventory.get(CashType.BILL_200) % 200;
        int requiredNotes = remainingAmount / 200;

        if(requiredNotes > 0){
            cashInventory.put(CashType.BILL_200, cashInventory.get(CashType.BILL_200) - requiredNotes);
            dispensedCash.put(CashType.BILL_200, requiredNotes);
        }
        if(remainingAmount == 0){
            return;
        }

        super.withdrawAmount(cashInventory, remainingAmount, dispensedCash);
    }
}

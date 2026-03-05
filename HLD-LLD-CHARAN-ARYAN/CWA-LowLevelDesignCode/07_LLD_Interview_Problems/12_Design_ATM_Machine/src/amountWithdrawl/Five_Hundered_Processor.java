package amountWithdrawl;

import CommonEnum.CashType;

import java.util.Map;

public class Five_Hundered_Processor extends AmountWithdraw_Processor {

    public Five_Hundered_Processor(AmountWithdraw_Processor nextProcessor) {
        super(nextProcessor);
    }

    public void withdrawAmount(Map<CashType, Integer> cashInventory, int amount, Map<CashType, Integer> dispensedCash){

        int remainingAmount = cashInventory.get(CashType.BILL_500) % 500;
        int requiredNotes = remainingAmount / 500;

        if(requiredNotes > 0){
            cashInventory.put(CashType.BILL_500, cashInventory.get(CashType.BILL_500) - requiredNotes);
            dispensedCash.put(CashType.BILL_500, requiredNotes);
        }

        if(remainingAmount == 0){
            return;
        }

        super.withdrawAmount(cashInventory, remainingAmount, dispensedCash);
    }
}

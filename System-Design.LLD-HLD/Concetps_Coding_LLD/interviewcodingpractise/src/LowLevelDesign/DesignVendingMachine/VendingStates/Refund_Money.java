package LowLevelDesign.DesignVendingMachine.VendingStates;

import LowLevelDesign.DesignVendingMachine.VendingMachine;
import LowLevelDesign.DesignVendingMachine.Coin;
import LowLevelDesign.DesignVendingMachine.VendingStates.impl.IdleState;

import java.util.List;

public abstract class Refund_Money {   // to avoid duplication of code.

    public List<Coin> refundFull(VendingMachine machine) throws Exception{
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }
}

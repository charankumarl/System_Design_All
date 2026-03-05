package LowLevelDesign.DesignSplitwise.Expense.Split.CreateSplit;

import LowLevelDesign.DesignSplitwise.Expense.ExpenseSplitType;
import LowLevelDesign.DesignSplitwise.Expense.Split.Split;
import LowLevelDesign.DesignSplitwise.User.User;

import java.util.List;

public class EqualCreateSplit implements CreateSplit{

    @Override
    public List<Split> createSplit(List<User> userList, double amount, ExpenseSplitType splitType, User paidBy) {

        double splitAmount = amount / userList.size();

        for(User user : userList){

            if(!user.equals(paidBy)){
                Split split = new Split(user, 0);
                this.split.add(split);
            }
            else{
                Split split = new Split(user, splitAmount);
                this.split.add(split);
            }
        }

        return this.split;
    }
}

package LowLevelDesign.DesignSplitwise.Expense.Split.CreateSplit;

import LowLevelDesign.DesignSplitwise.Expense.ExpenseSplitType;
import LowLevelDesign.DesignSplitwise.Expense.Split.Split;
import LowLevelDesign.Design_Payment_Gateway.User.User;

import java.util.ArrayList;
import java.util.List;

public interface CreateSplit {

    List<Split> split = new ArrayList<>();

    List<Split> createSplit(List<LowLevelDesign.DesignSplitwise.User.User> userList, double amount, ExpenseSplitType splitType, LowLevelDesign.DesignSplitwise.User.User paidBy);
}

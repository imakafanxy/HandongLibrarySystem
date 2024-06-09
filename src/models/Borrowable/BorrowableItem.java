package models.Borrowable;

import models.Borrowable.Strategy.AddStrategy;
import models.Borrowable.Strategy.Borrow.BorrowStrategy;
import models.Borrowable.Strategy.Return.ReturnStrategy;

public abstract class BorrowableItem {
//    private BorrowStrategy borrowStrategy;
//    private ReturnStrategy returnStrategy;
//
//    public void borrowed() {
//        borrowStrategy.borrowItem();
//    }
//
//    public void returned() {
//        returnStrategy.returnItem();
//    }
//
//    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
//        this.borrowStrategy = borrowStrategy;
//    }
//
//    public void setReturnStrategy(ReturnStrategy returnStrategy) {
//        this.returnStrategy = returnStrategy;
//    }

    private AddStrategy addStrategy;

    public void addItem() {
        addStrategy.add(this);
    }

    public void setAddStrategy(AddStrategy addStrategy) {
        this.addStrategy = addStrategy;
    }
}

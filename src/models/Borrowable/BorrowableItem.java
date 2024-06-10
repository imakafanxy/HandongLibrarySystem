package models.Borrowable;

import models.Borrowable.Strategy.AddStrategy;


public abstract class BorrowableItem {

    private AddStrategy addStrategy;

    public void addItem() {
        addStrategy.add(this);
    }

    public void setAddStrategy(AddStrategy addStrategy) {
        this.addStrategy = addStrategy;
    }
}

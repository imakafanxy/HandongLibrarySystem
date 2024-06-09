package models.Borrowable.Strategy;

import models.Borrowable.BorrowableItem;

public class CDAddStrategy implements AddStrategy {
    @Override
    public void add(BorrowableItem CD) {
        System.out.println("Add CD");
    }
}

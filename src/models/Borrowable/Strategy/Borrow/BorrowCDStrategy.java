package models.Borrowable.Strategy.Borrow;

public class BorrowCDStrategy implements BorrowStrategy {
    @Override
    public void borrowItem() {
        System.out.println("Borrow CD");
    }
}

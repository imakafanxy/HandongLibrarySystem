package models.Borrowable.Strategy.Borrow;

public class BorrowBookStrategy implements BorrowStrategy {
    @Override
    public void borrowItem() {
        System.out.println("Borrow Book");

    }
}

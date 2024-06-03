package main.java.utility.ButtonCommand;

// Concrete Command
public class BorrowCommand implements ButtonCommand {
    private final ButtonUtils buttonUtils;

    public BorrowCommand(ButtonUtils buttonUtils) {
        this.buttonUtils = buttonUtils;
    }

    @Override
    public void buttonPress() {
        buttonUtils.borrowBook();
    }
}
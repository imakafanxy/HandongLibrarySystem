package main.java.utility.ButtonCommand;

public class AddBookCommand implements ButtonCommand {
    private ButtonReceiver receiver;

    public AddBookCommand(ButtonReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void buttonPress() {
        receiver.openAddBookView();
    }
}

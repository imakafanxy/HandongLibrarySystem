package main.java.utility.ButtonCommand;

// Concrete Command
public class ConfirmCommand implements ButtonCommand{

    @Override
    public void buttonPress() {
        ButtonUtils.confirm();
    }
}
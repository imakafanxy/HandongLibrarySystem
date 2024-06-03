package main.java.utility.ButtonCommand;

// Concrete Command
public class ExitCommand implements ButtonCommand {

    @Override
    public void buttonPress() {
        ButtonUtils.exitProgram();
    }
}
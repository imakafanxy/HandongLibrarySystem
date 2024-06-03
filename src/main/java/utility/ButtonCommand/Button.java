package main.java.utility.ButtonCommand;

// Invoker
public class Button {
    private ButtonCommand buttonCommand;

    public Button(ButtonCommand buttonCommand) {
        this.buttonCommand = buttonCommand;
    }

    public void setCommand(ButtonCommand newCommand) {
        this.buttonCommand = newCommand;
    }

    public void pressed() {
        buttonCommand.buttonPress();
    }
}

package utility.ButtonCommand;

import javax.swing.*;

// Invoker
public class Button extends JButton {
    private ButtonCommand buttonCommand;

    public Button(ButtonCommand buttonCommand) {
        setCommand(buttonCommand);
    }

    public void setCommand(ButtonCommand newCommand) {
        this.buttonCommand = newCommand;
    }

    public void pressed() {
        buttonCommand.buttonPress();
    }
}

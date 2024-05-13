package utility.ButtonCommand;

public class Button {
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

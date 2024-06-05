package utility.ButtonCommand;

// Concrete Command
public class CancelCommand implements ButtonCommand {

    @Override
    public void buttonPress() {
        ButtonUtils.cancel();

    }
}

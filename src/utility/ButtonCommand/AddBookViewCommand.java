package utility.ButtonCommand;

import views.AddBookView;

public class AddBookViewCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        AddBookView.getInstance();
    }
}

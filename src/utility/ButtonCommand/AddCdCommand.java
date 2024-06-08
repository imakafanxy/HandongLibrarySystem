package utility.ButtonCommand;

import views.AddCdView;

public class AddCdCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        AddCdView addCdView = new AddCdView();
        addCdView.setVisible(true);
    }
}

package utility.ButtonCommand;

import views.AddCdView;

public class AddCdViewCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        AddCdView.getInstance();
    }
}

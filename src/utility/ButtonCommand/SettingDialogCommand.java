package utility.ButtonCommand;

import components.SettingDialog;
import views.MainViewBuilder.MainView;

public class SettingDialogCommand implements ButtonCommand {
    MainView mainView;

    public SettingDialogCommand(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void buttonPress() {
        SettingDialog settingDialog = new SettingDialog(mainView);
    }
}

package main.java.utility.ButtonCommand;

import javax.swing.*;

import main.java.components.SettingDialog;

public class SettingsCommand implements ButtonCommand {
    private JFrame frame;

    public SettingsCommand(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void buttonPress() {
        SettingDialog settingsDialog = new SettingDialog(frame);
        settingsDialog.setVisible(true);
    }
}

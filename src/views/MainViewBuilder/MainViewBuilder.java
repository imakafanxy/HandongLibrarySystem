package views.MainViewBuilder;

import utility.ButtonCommand.ButtonCommand;

// abstract builder
public interface MainViewBuilder {

    public void buildPanel();

    public void buildButton();

    public void buildLabel();

    public MainView getMainView();
}

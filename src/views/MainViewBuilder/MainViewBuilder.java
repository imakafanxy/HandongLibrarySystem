package views.MainViewBuilder;

// abstract builder
public interface MainViewBuilder {

    void buildPanel();

    void buildButton();

    void buildLabel();

    MainView getMainView();
}

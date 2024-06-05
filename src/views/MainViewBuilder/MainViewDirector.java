package views.MainViewBuilder;

public class MainViewDirector {
    private MainViewBuilder builder;

    public MainViewDirector(MainViewBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPanel();
        builder.buildButton();
        builder.buildLabel();
    }
}

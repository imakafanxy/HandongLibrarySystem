package main.java.utility.ButtonCommand;

import main.java.views.AddBookView;

public class ButtonReceiver {
    public void openAddBookView() {
        AddBookView addBookView = new AddBookView();
        addBookView.setVisible(true);
    }
}

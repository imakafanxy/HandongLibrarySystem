package views.MainViewBuilder;

import models.People.Products.Person;
import utility.PersonNotifier.PersonObserver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Builder: Product
public class MainView extends JFrame implements PersonObserver {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    private JPanel panel;
    private List<JButton> buttons;
    private JLabel label;

    private Person person;

    public MainView() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setTitle("MainView");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        buttons = new ArrayList<>();
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
        add(panel);
    }

    public void setButton(JButton button) {
        buttons.add(button);
        panel.add(button);
    }

    public void setLabel(JLabel label) {
        this.label = label;
        panel.add(label);
    }

    @Override
    public void updateCurrentPerson(Person currentPerson) {
        person = currentPerson;

        setTitle(person.getName() + "'s Main View");
    }
}

package utility.ButtonCommand;

import views.SignUpView;

public class SignUpViewCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        SignUpView.getInstance();
    }
}

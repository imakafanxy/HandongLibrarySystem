package utility.ButtonCommand;

import views.SignInView;

public class SignInViewCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        SignInView.getInstance();
    }
}

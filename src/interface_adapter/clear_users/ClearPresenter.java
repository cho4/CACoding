package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;

public class ClearPresenter implements ClearOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final ClearViewModel clearViewModel;
    private final ViewManagerModel viewManagermodel;

    public ClearPresenter(ClearViewModel clearViewModel, ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.clearViewModel = clearViewModel;
        this.viewManagermodel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView() {
        // On success, switch to the signup view.

        SignupState signupState = signupViewModel.getState();
        this.signupViewModel.setState(signupState);
        this.signupViewModel.firePropertyChanged();

        this.viewManagermodel.setActiveView(signupViewModel.getViewName());
        this.viewManagermodel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setClearError(error);
        clearViewModel.firePropertyChanged();
    }

}

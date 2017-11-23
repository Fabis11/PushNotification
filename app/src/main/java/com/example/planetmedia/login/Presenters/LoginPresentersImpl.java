package com.example.planetmedia.login.Presenters;

import com.example.planetmedia.login.Interactors.LoginInteractorImpl;
import com.example.planetmedia.login.Interfaces.LoginInteractor;
import com.example.planetmedia.login.Interfaces.LoginPresenter;
import com.example.planetmedia.login.Interfaces.LoginView;
import com.example.planetmedia.login.Interfaces.OnLoginFinishListener;

/**
 * Created by PLANETMEDIA on 31/10/2017.
 */

public class LoginPresentersImpl implements LoginPresenter,OnLoginFinishListener {
    private LoginView view;
    private LoginInteractor interactor;
    public LoginPresentersImpl(LoginView view){
        this.view=view;
        interactor=new LoginInteractorImpl();
    }
    @Override
    public void validarUsiario(String user, String pass) {
        if(view!=null){
            view.showProgress();

        }
        interactor.validaUser(user,pass,this);
    }

    @Override
    public void usernameError() {
        if(view !=null){
            view.hideProgress();
            view.setErrorUser();
        }

    }

    @Override
    public void passwordError() {
        if(view!=null){
            view.hideProgress();
            view.setErrorPassword();
        }

    }

    @Override
    public void exitoOperacion() {
        if(view!=null){
            view.hideProgress();
            view.navigateToHome();
        }

    }
}

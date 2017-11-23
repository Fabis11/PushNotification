package com.example.planetmedia.login.Interfaces;

/**
 * Created by PLANETMEDIA on 31/10/2017.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();

    void navigateToHome();
}

package com.example.planetmedia.login.Interfaces;

/**
 * Created by PLANETMEDIA on 31/10/2017.
 */

public interface LoginInteractor {
    void validaUser(String usu, String pass, OnLoginFinishListener listener);
}

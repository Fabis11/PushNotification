package com.example.planetmedia.login.Interactors;

import android.os.Handler;

import com.example.planetmedia.login.Interfaces.LoginInteractor;
import com.example.planetmedia.login.Interfaces.OnLoginFinishListener;

/**
 * Created by PLANETMEDIA on 31/10/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    //final Handler handler=new Handler();
    @Override
    public void validaUser(final String user, final String pass, final OnLoginFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!user.equals("")&&!pass.equals("")){
                    listener.exitoOperacion();
                }else{
                    if(user.equals("")){
                        listener.usernameError();
                    }
                    if(pass.equals("")){
                        listener.usernameError();
                    }
                }
            }
        },2000);


    }
}

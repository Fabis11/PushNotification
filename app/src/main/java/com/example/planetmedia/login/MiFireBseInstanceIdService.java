package com.example.planetmedia.login;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by PLANETMEDIA on 22/11/2017.
 */

public class MiFireBseInstanceIdService extends FirebaseInstanceIdService {
    public static final String TAG="NOTICIAS";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Token: "+ token);
        //prueba
    }
}

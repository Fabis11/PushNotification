package com.example.planetmedia.login;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.planetmedia.login.View.Login;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by PLANETMEDIA on 22/11/2017.
 */

public class MiFireBaseMessagingService extends FirebaseMessagingService {
    public static final String TAG="NOTICIAS";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String from=remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: "+from);
        if (remoteMessage.getNotification() !=null){
            Log.d(TAG,"Notificación: "+ remoteMessage.getNotification().getBody());
            mostrarNotificacion(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }
        if(remoteMessage.getData().size()>0){
            Log.d(TAG,"Data: "+remoteMessage.getData());
        }
    }

    private void mostrarNotificacion(String title, String body) {
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificacionBuilder =new NotificationCompat.Builder(this);
            notificacionBuilder.setSmallIcon(R.drawable.ic_event);
            notificacionBuilder.setContentTitle(title);
            notificacionBuilder.setContentText(body);
            notificacionBuilder.setAutoCancel(true);
            notificacionBuilder.setSound(soundUri);
            notificacionBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificacionBuilder.build());
    }
    //comentario prueba
}

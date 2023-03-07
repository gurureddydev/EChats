package com.gurureddy.chattingapp.firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.gurureddy.chattingapp.R;
import com.gurureddy.chattingapp.activity.ChatActivity;
import com.gurureddy.chattingapp.models.User;
import com.gurureddy.chattingapp.utilities.Constants;
import java.util.Random;

public class MessagingService extends  FirebaseMessagingService{
    private User receiverUser;
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        User user = new User();
        user.id = remoteMessage.getData().get(Constants.KEY_USER_ID);
        user.name = remoteMessage.getData().get(Constants.KEY_NAME);
        user.token = remoteMessage.getData().get(Constants.KEY_FCM_TOKEN);

        int notification = new Random().nextInt();
        String channelId = "chat_messageS";

        Intent intent = new Intent(this, ChatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(Constants.KEY_USER,user);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,0);
        NotificationCompat.Builder builder= new  NotificationCompat.Builder( this,channelId);
        builder.setSmallIcon(R.drawable.notifi);
        builder.setContentText(remoteMessage.getData().get(Constants.KEY_MESSAGE));
        builder.setContentTitle(remoteMessage.getData().get(Constants.KEY_NAME));
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(pendingIntent);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence channelName ="Chat Message";
            String channelDescription  ="This Notification channel is used for chat message notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName,importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(notification,builder.build());



    }
}

package com.gurureddy.chattingapp.utilities;

import java.util.HashMap;

public class Constants {
    public static  final  String KEY_COLLECTION_USERS="users";
    public static final  String KEY_NAME ="name";
    public static final String KEY_EMAIL ="email";
    public static final String KEY_PASSWORD ="password";
    public static final String KEY_PREFERENCE_NAME = "chatAppPreference";
    public static final String KEY_IS_SIGNED_IN = "isSignedIn";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_FCM_TOKEN = "fcmToken";
    public static final String KEY_USER = "user";
    public static final String KEY_SENDER_ID="senderId";
    public static final String KEY_RECEIVER_ID = "receiverId";
    public static final String KEY_MESSAGE ="message";
    public static final String KEY_TIMESTAMP="timestamp";
    public static final String KEY_COLLECTION_CHAT="chat";
    public static final String KEY_COLLECTION_CONVERSATION ="conversation";
    public static final String KEY_SENDER_NAME ="senderName";
    public static final String KEY_RECEIVER_NAME="receiverName";
    public static final String KEY_SENDER_IMAGE ="senderImage";
    public static final String KEY_RECEIVER_IMAGE="receiverImage";
    public static final String KEY_LAST_MESSAGE="lastMessage;";
    public static final String KEY_AVAILABILITY ="availability";
    public static final String REMOTE_MSG_AUTHORIZATION ="Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE="Content-Type";
    public static final String REMOTE_MSG_DATA ="data";
    public static final String REMOTE_MSG_REGISTRATION_IDS="registration_ids";
    public static final String ACTION_ARCHIVE="ACTION_ARCHIVE";
    public static final String ACTION_REPLY="ACTION_REPLY";
    public static final String KEY_QUICK_REPLY_TEXT = "quick_reply";


    public static HashMap<String, String> remoteMsgHeaders = null;
    public static HashMap<String, String> getRemoteMsgHeaders(){
        if (remoteMsgHeaders == null){
            remoteMsgHeaders = new HashMap<>();
            remoteMsgHeaders.put(
                    REMOTE_MSG_AUTHORIZATION,
                    "key=AAAAM0OJAuo:APA91bHx-vx0bcASbU6dDS5ftfrCmiQAAnDqYdH-0x0C4zqfBORKdYVeAezFvmJI-_SoaeCDixLPPF9CtiWCPUgbpWKWUNsI2DO5eWc72ZyW95AXnnmaVgVgrWIvV0spSl2Db9OTI7Yk"
            );
            remoteMsgHeaders.put(
                    REMOTE_MSG_CONTENT_TYPE,
                    "application/json"
            );
        }
        return remoteMsgHeaders;
    }




}

package in.helpchat.voiceproject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    // type of notification:
    // 1. Collapse: simple, title, sub content, emoji
    // 2. Expanded: Text, sub content, Image-text, Text-Cta, Image-cta

    private final int REQ_CODE_SPEECH_INPUT = 100;

    private View btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.text);
        final String title = "Horoscope - Leo some random text can also be added here as required";
        final String content = "Some xyz content will go here al sdohas odas dhas di asd asdonsa d asd iashd ihais dh as i said i ";
        final String subContent = "#21 likes and more";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setAutoCancel(true)
                        .setContentTitle(title)
                        .setContentText(content)
                        .setSmallIcon(R.drawable.ic_notification);

                RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_subcontent_notification);
                RemoteViewUtil.setImageBitmap(remoteView, R.id.icon, getNotificationImage());
                RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
                RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
                RemoteViewUtil.setText(remoteView, R.id.sub_content, subContent, 0);
                RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);

                builder.setContent(remoteView);

                remoteView = new RemoteViews(context.getPackageName(), R.layout.expanded_text_notification);
                RemoteViewUtil.setImageBitmap(remoteView, R.id.icon, getNotificationImage());
                RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
                RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
                RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);


                Notification build = builder.build();
                build.bigContentView = remoteView;
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1, build);

                builder = new NotificationCompat.Builder(context);
                builder.setAutoCancel(true)
                        .setContentTitle(title)
                        .setContentText(content)
                        .setSmallIcon(R.drawable.ic_notification);
                manager.notify(2, builder.build());
            }
        });
    }


    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Select input");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Not supported", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView.setText(result.get(0));
                }
                break;
            }

        }
    }


    @Nullable
    public Bitmap getNotificationImage() {
        Context context = this;
        Bitmap largeIcon = null;
        //set largeIcon from URL
        largeIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
        Bitmap overflowIconBmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_notification);
        float requiredWidth = largeIcon.getWidth() + 0.5f * overflowIconBmp.getWidth();
        float requiredHeight = largeIcon.getHeight() + 0.5f * overflowIconBmp.getHeight();
        float srcPoint = largeIcon.getWidth() - 0.5f * overflowIconBmp.getWidth();
        float desPoint = largeIcon.getHeight() - 0.5f * overflowIconBmp.getHeight();

        Bitmap bitmap = Bitmap.createBitmap((int) requiredWidth, (int) requiredHeight, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);

        canvas.drawBitmap(largeIcon, new Matrix(), new Paint());
        canvas.drawBitmap(overflowIconBmp, srcPoint, desPoint, null);

        return largeIcon;
    }
}

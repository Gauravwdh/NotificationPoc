package in.helpchat.voiceproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Created by gauravwadhwa on 23/06/16.
 */

public class Handler {

    private String[] titles;
    private String[] contents;

    private final NotificationManager manager;
    private Context context;

    public Handler(Context context) {
        this.context = context;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public String getTitle() {
        return "Horoscope - Leo some random text can also be added here as required";
    }

    public String getContent() {
        return "Some xyz content will go here al sdohas odas dhas di asd asdonsa d asd iashd ihais dh as i said i ";
    }

    public void showCollapseSimple() {
        String title = getTitle();
        String content = getContent();
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_simple_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setContent(remoteView);
        manager.notify(1, builder.build());
    }

    public void showCollapseTitle() {
        String title = getTitle();
        String content = getContent();
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_title_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setContent(remoteView);
        manager.notify(2, builder.build());
    }

    public void showCollapseSubContent() {
        String title = getTitle();
        String content = getContent();
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_subcontent_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.sub_content, "213 likes", 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setContent(remoteView);
        manager.notify(3, builder.build());
    }

    public void showCollapseEmoji() {
        String title = "Sports Notification which can extend upto 2 lines of text ";
        String content = getContent();
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_emoji_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        RemoteViewUtil.setImageBitmap(remoteView,R.id.emoji_icon_first,BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_cab));
        RemoteViewUtil.setImageBitmap(remoteView,R.id.emoji_icon_last,BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_cab));
        RemoteViewUtil.setVisibility(remoteView,R.id.emoji_icon_first, View.VISIBLE);
        RemoteViewUtil.setVisibility(remoteView,R.id.emoji_icon_last, View.VISIBLE);
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setContent(remoteView);
        manager.notify(10, builder.build());
    }

    public void showCollapseNative() {
        String title = getTitle();
        String content = getContent();
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
        manager.notify(5, builder.build());
    }

    public void showExpandedText() {
        String title = getTitle();
        String content = getContent();
        NotificationCompat.Builder builder = getBuilderTest(title, content);

        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.expanded_text_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        Notification build = builder.build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            build.bigContentView = remoteView;
        } else {
            build.contentView = remoteView;
        }
        manager.notify(6, build);
    }


    public void showExpandedTextCta() {
        String title = getTitle();
        String content = getContent();
        NotificationCompat.Builder builder = getBuilderTest(title, content);

        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.expanded_text_cta_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        Notification build = builder.build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            build.bigContentView = remoteView;
        } else {
            build.contentView = remoteView;
        }
        manager.notify(7, build);
    }


    public void showExpandedTextImage() {
        String title = getTitle();
        String content = getContent();
        NotificationCompat.Builder builder = getBuilderTest(title, content);

        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.epanded_image_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        Notification build = builder.build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            build.bigContentView = remoteView;
        } else {
            build.contentView = remoteView;
        }
        manager.notify(8, build);
    }

    public void showExpandedSubText() {
        String title = getTitle();
        String content = getContent();
        NotificationCompat.Builder builder = getBuilderTest(title, content);

        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.expanded_subcontent_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        RemoteViewUtil.setText(remoteView, R.id.sub_content, "231 likes", 0);
        Notification build = builder.build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            build.bigContentView = remoteView;
        } else {
            build.contentView = remoteView;
        }
        manager.notify(9, build);
    }


    private NotificationCompat.Builder getBuilder(String title, String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setAutoCancel(true)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_small_icon);
        return builder;
    }

    private NotificationCompat.Builder getBuilderTest(String title, String content) {
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.collapse_simple_notification);
        RemoteViewUtil.setText(remoteView, R.id.title, title, 0);
        RemoteViewUtil.setText(remoteView, R.id.content, content, 0);
        RemoteViewUtil.setText(remoteView, R.id.sub_content, "213 likes", 0);
        RemoteViewUtil.setText(remoteView, R.id.time, "10:31 pm", 0);
        NotificationCompat.Builder builder = getBuilder(title, content);
        builder.setContent(remoteView);
        return builder;
    }

}

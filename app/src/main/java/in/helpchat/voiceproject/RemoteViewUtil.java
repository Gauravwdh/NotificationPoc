package in.helpchat.voiceproject;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Created by gauravwadhwa on 11/12/15.
 */
public class RemoteViewUtil {

    public static final String VISIBLE = "visible";
    public static final String INVISIBLE = "invisible";
    public static final String GONE = "gone";

    public static void setBackgroundResource(RemoteViews views, int id, int drawable) {
        views.setInt(id, "setBackgroundResource", drawable);
    }

    public static void setText(RemoteViews views, int id, String text, int color) {
        views.setTextViewText(id, text == null ? "" : text);
        if(color!=0) {
            views.setTextColor(id, color);
        }
    }
    public static void setText(RemoteViews views, int id, CharSequence text, int color) {
        views.setTextViewText(id, text == null ? "" : text);
        if(color!=0) {
            views.setTextColor(id, color);
        }
    }

    public static void setText(RemoteViews views, int id, String text){
        setText(views, id, text, 0);
    }

    public static void removeView(RemoteViews views,int id){
        views.removeAllViews(id);
    }


    public static void setDrawable(RemoteViews views, int id, int drawableId) {
        views.setImageViewResource(id,drawableId);

    }

    public static void setVisibility(RemoteViews views, int id, int visibility) {
        views.setViewVisibility(id,visibility);

    }

    public static void setImageBitmap(RemoteViews view, int id, Bitmap bitmap) {
        if (bitmap != null) {
            view.setBitmap(id, "setImageBitmap", bitmap);
        }
    }

    public static void setBackgroundColor(RemoteViews view, int id, int color) {
        view.setInt(id, "setBackgroundColor", color);
    }

    public static void setVisibility(RemoteViews view, int id, String visibility) {
        if (visibility.equals(VISIBLE))
            view.setViewVisibility(id, View.VISIBLE);
        else if (visibility.equals(INVISIBLE)) {
            view.setViewVisibility(id, View.INVISIBLE);
        } else {
            view.setViewVisibility(id, View.GONE);
        }

    }
}

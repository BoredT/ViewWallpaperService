package com.example.borednerd.viewlivewallpaper;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class TextViewWallpaperService extends ViewWallpaperService {

    @Override
    public View getView() {
        TextView textView = new TextView(this);
        textView.setText("TextViewWallpaperService");
        textView.setGravity(Gravity.CENTER_VERTICAL);
        return textView;
    }
}

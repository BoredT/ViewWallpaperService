package com.example.borednerd.viewlivewallpaper;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InflatedViewWallpaperService extends ViewWallpaperService {

    @Override
    public View getView() {
        return LayoutInflater.from(this).inflate(R.layout.test_inflater, null);
    }

}

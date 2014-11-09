package com.example.borednerd.viewlivewallpaper;

import android.view.View;
import android.widget.ImageView;

public class ImageViewWallpaperService extends ViewWallpaperService {

    @Override
    public View getView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        return imageView;
    }
}

package com.example.borednerd.viewlivewallpaper;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.wallpaper.IWallpaperConnection;
import android.service.wallpaper.IWallpaperService;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public abstract class ViewWallpaperService extends Service {

    private static final String TAG = "ViewWallpaperService";
    private WindowManager mWindowManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        mWindowManager = null;
        super.onDestroy();
    }

    @Override
    public final IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return new IWallpaperService.Stub() {
            @Override
            public void attach(IWallpaperConnection connection, final IBinder windowToken, final int windowType, final boolean isPreview,final  int reqWidth, final int reqHeight) throws RemoteException {
                Log.d(TAG, "attach()");
                Log.d(TAG, "isPreview: " + isPreview);

                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mWindowManager.addView(getView(), getWindowParams(windowToken, windowType, reqWidth, reqHeight));
                    }
                });
            }
        };
    }

    private WindowManager.LayoutParams getWindowParams(IBinder windowToken, int windowType, int reqWidth, int reqHeight) {
        WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();
        windowParams.x = 0;
        windowParams.y = 0;
        windowParams.width = reqWidth;
        windowParams.height = reqHeight;
        windowParams.type = windowType;
        windowParams.token = windowToken;
        windowParams.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        return windowParams;
    }

    /**
     * Must be implemented to return a regular View.
     */
    public abstract View getView();
}

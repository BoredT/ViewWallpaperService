package com.example.borednerd.viewlivewallpaper;

import android.content.Intent;
import android.os.RemoteException;
import android.service.wallpaper.IWallpaperService;
import android.test.ServiceTestCase;

public class ServiceTest extends ServiceTestCase<InflatedViewWallpaperService> {

    public ServiceTest() {
        super(InflatedViewWallpaperService.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testStartable() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(), InflatedViewWallpaperService.class);
        startService(startIntent);
        shutdownService();
    }

    public void testBindable() throws RemoteException {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(), InflatedViewWallpaperService.class);
        IWallpaperService service = IWallpaperService.Stub.asInterface(bindService(startIntent));

        //TODO: test service.attach
    }

}

package com.cs442.apipalia.memorygame;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSoundService extends Service {
    MediaPlayer player;
    public BackgroundSoundService() {
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(BackgroundSoundService.this, R.raw.backgroun);
        player.setLooping(true);
        player.setVolume(100, 100);

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}

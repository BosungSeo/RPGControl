package com.onebee.rpgcontrol.app.Core;

import android.os.Handler;
import android.os.SystemClock;

class GameScheduler extends Thread {
    int count = 0;
    private Handler sendHandler;

    public GameScheduler(Handler sendHandler) {
        this.sendHandler = sendHandler;
    }

    @Override
    public void run() { // 핸들러로 카운터를 보낸다.

        while (true) {
            sendHandler.sendEmptyMessage(count);
            count++;
            if (count == 100)
                break;
            SystemClock.sleep(1000L);
        }
    }
}
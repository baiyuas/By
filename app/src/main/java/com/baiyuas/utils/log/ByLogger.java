package com.baiyuas.utils.log;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class ByLogger {

    /**
     * 默认Tag
     */
    private final static String DEFAULT_TAG = "hbmcc log:";

    public static void log(@NonNull String msg) {
        log(msg, LogLevel.D);
    }

    public static void log(@NonNull String msg, @LogLevelAnnotation int level) {
        switch (level) {
            case LogLevel.V:
                Logger.v(msg);
                break;
            case LogLevel.D:
                Logger.d(msg);
                break;
            case LogLevel.I:
                Logger.i(msg);
                break;
            case LogLevel.W:
                Logger.w(msg);
                break;
            case LogLevel.E:
                Logger.e(msg);
                break;
            case LogLevel.JSON:
                Logger.json(msg);
                break;
            case LogLevel.XML:
                Logger.xml(msg);
                break;
            default:
                Logger.d(msg);
                break;
        }
    }
}

package com.baiyuas.utils.log;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.logging.Logger;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@IntDef({LogLevel.V, LogLevel.D, LogLevel.I, LogLevel.W, LogLevel.E, LogLevel.JSON, LogLevel.XML})
@Retention(RetentionPolicy.SOURCE)
public @interface LogLevelAnnotation {
}

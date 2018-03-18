package com.baiyuas.model.http.cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class CookieManager implements CookieJar {

    private Map<String, List<Cookie>> cookieMap = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        String host = url.host();

        List<Cookie> cookieList = cookieMap.get(url);
        if (cookieList != null) {
            cookieMap.remove(cookieList);
        }
        cookieMap.put(host, cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookieMap.get(url.host()) == null ? new ArrayList<>() : cookieMap.get(url.host());
    }
}

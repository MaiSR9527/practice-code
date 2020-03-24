package com.msr.test.process;

import okhttp3.*;

import java.io.IOException;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/3/22 17:28
 * @version: v1.0
 */

public class OkHttpHelper {
    public static OkHttpClient newSession() {
        return new OkHttpClient.Builder()
//                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8118)))
//                .proxy(Proxy.NO_PROXY)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .cookieJar(new JavaNetCookieJar(new CookieManager()))
                .build();
    }

    public static Response post(OkHttpClient client, String url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return client.newCall(request).execute();
    }

    public static Response get(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return client.newCall(request).execute();
    }

    public static void main(String[] args) {
        try {
            Response response = get(newSession(), "https://www.processon.com/i/5dd8c8a4e4b0bbcb8a69d6f3");
            if (response.isSuccessful()) {
                System.out.println(response.body());
                System.out.println(response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

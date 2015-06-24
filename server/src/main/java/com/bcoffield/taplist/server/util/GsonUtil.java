package com.bcoffield.taplist.server.util;

import com.google.gson.Gson;

public class GsonUtil {
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            initGson();
        }
        return gson;
    }

    private static void initGson() {
        gson = new Gson();
    }
}

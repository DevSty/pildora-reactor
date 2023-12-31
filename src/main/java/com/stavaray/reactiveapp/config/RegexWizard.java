package com.stavaray.reactiveapp.config;

import java.net.URI;

public class RegexWizard {

    public static String getJdbcHost(String jdbc) {
        return getUri(jdbc).getHost();
    }

    public static int getJdbcPort(String jdbc) {
        return getUri(jdbc).getPort();
    }

    public static String getDbName(String jdbc) {
        return getUri(jdbc).getPath().substring(1);
    }

    private static URI getUri(String jdbc) {
        String substring = jdbc.substring(5);
        return URI.create(substring);
    }
}

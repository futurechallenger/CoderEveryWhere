package com.service.mymodule.lib;

/**
 * Created by uncle_charlie on 26/9/15.
 */

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class CEWHttpClient {
    private static final String BAES_HTTP_STRING = "http";
    private static final String BAES_URL = "http://";
    private static AsyncHttpClient _client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        _client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        _client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        String absoluteUrl = "";
        if (relativeUrl.indexOf(BAES_HTTP_STRING) > -1) {
            absoluteUrl = relativeUrl;
        } else {
            absoluteUrl = BAES_URL + relativeUrl;
        }

        return absoluteUrl;
    }
}

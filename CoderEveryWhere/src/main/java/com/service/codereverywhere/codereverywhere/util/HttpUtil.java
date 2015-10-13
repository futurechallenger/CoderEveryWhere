package com.service.codereverywhere.codereverywhere.util;

import android.content.Context;
import android.text.TextUtils;
import com.loopj.android.http.*;
import com.service.codereverywhere.codereverywhere.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uncle_charlie on 26/9/15.
 */
public class HttpUtil {
    private static final String TAG = HttpUtil.class.getName();

    private static final String APP_SIGN = "app_sign";
    private static final String BAES_HTTP_STRING = "http";
    private static final String BAES_URL = "http://";

    private static final int TIMEOUT_SHORT = 60000;
    private static final int MAX_CONNECTION_COUNT = 10;
    public static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    private static HttpUtil _httpUtil;

    static {
        asyncHttpClient.setTimeout(TIMEOUT_SHORT);
        asyncHttpClient.setMaxConnections(MAX_CONNECTION_COUNT);
    }

    public static HttpUtil httpUtil() {
        if (_httpUtil == null) {
            _httpUtil = new HttpUtil();
        }
        return _httpUtil;
    }

    private RequestParams legalize(Map<String, String> params) {
        if (params.isEmpty())
            params = new HashMap<String, String>();

        RequestParams requestParams = new RequestParams(params);

//        requestParams.put(APPSIGN, getSign(params));
        LogUtil.info("Http Params", R.id.http_params, "=============Request Params Start================");
        LogUtil.info("Http Params", R.id.http_params, "Request Legalize Params>>>>>" + requestParams.toString());
        LogUtil.info("Http Params", R.id.http_params, "=============Request Params End================");
        return requestParams;
    }

    public void get(String url, AsyncHttpResponseHandler responseHandler) {
        LogUtil.info("Http Get", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Get", R.id.http_get, "Request Url>>>>>" + getAbsoluteUrl(url));
        LogUtil.info("Http Get", R.id.http_get, "=============Request End================");
        asyncHttpClient.get(getAbsoluteUrl(url), responseHandler);
    }

    public void get(String url, Map<String, String> params, AsyncHttpResponseHandler responseHandler) {
        LogUtil.info("Http Get", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Get", R.id.http_get, "Request Url>>>>>" + getAbsoluteUrl(url) + legalize(params));
        if (!params.isEmpty())
            LogUtil.info("Http Get", R.id.http_get, "Request Params>>>>>" + params.toString());
        LogUtil.info("Http Get", R.id.http_get, "=============Request End================");

        asyncHttpClient.get(getAbsoluteUrl(url), legalize(params), responseHandler);
    }

    /**
     * 返回Json非参数
     *
     * @param url
     * @param responseHandler
     */
    public void get(String url, JsonHttpResponseHandler responseHandler) {
        LogUtil.info("Http Get", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Get", R.id.http_get, "Request Url>>>>>" + getAbsoluteUrl(url));
        LogUtil.info("Http Get", R.id.http_get, "=============Request End================");
        asyncHttpClient.get(getAbsoluteUrl(url), responseHandler);
    }

    /**
     * 返回Json带参数
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public void get(String url, Map<String, String> params, JsonHttpResponseHandler responseHandler) {
        LogUtil.info("Http Get", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Get", R.id.http_get, "Request Url>>>>>" + getAbsoluteUrl(url) + legalize(params));
        if (!params.isEmpty())
            LogUtil.info("Http Get", R.id.http_get, "Request Params>>>>>" + params.toString());
        LogUtil.info("Http Get", R.id.http_get, "=============Request End================");

        asyncHttpClient.get(getAbsoluteUrl(url), legalize(params), responseHandler);
    }

    /**
     * 返回Byte 非参数
     *
     * @param url
     * @param responseHandler
     */
    public void get(String url, BinaryHttpResponseHandler responseHandler) {
        LogUtil.info("Http Get", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Get", R.id.http_get, "Request Url>>>>>" + getAbsoluteUrl(url));
        LogUtil.info("Http Get", R.id.http_get, "=============Request End================");
        asyncHttpClient.get(getAbsoluteUrl(url), responseHandler);
    }

    /**
     * 返回String带参数
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public void post(String url, Map<String, String> params, AsyncHttpResponseHandler responseHandler) {
        LogUtil.info("Http Post", R.id.http_post, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Post", R.id.http_post, "Request Url>>>>>" + getAbsoluteUrl(url) + legalize(params));
        if (!params.isEmpty())
            LogUtil.info("Http Post", R.id.http_post, "Request Params>>>>>" + params.toString());
        LogUtil.info("Http Post", R.id.http_post, "=============Request End================");

        asyncHttpClient.post(getAbsoluteUrl(url), legalize(params), responseHandler);
    }

    /**
     * 返回Json带参数
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public void post(String url, Map<String, String> params, JsonHttpResponseHandler responseHandler) {
        LogUtil.info("Http Post", R.id.http_post, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Post", R.id.http_post, "Request Url>>>>>" + getAbsoluteUrl(url) + legalize(params));
        if (!params.isEmpty())
            LogUtil.info("Http Post", R.id.http_post, "Request Params>>>>>" + params.toString());
        LogUtil.info("Http Post", R.id.http_post, "=============Request End================");
        asyncHttpClient.post(getAbsoluteUrl(url), legalize(params), responseHandler);
    }

    /**
     * 返回Byte带参数
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public void post(String url, Map<String, String> params, BinaryHttpResponseHandler responseHandler) {
        LogUtil.info("Http Post", R.id.http_post, "=============Request Start================");
        if (!TextUtils.isEmpty(url))
            LogUtil.error("Http Post", R.id.http_post, "Request Url>>>>>" + getAbsoluteUrl(url));
        if (!params.isEmpty())
            LogUtil.info("Http Post", R.id.http_post, "Request Params>>>>>" + params.toString());
        LogUtil.info("Http Post", R.id.http_post, "=============Request End================");
        asyncHttpClient.post(url, legalize(params), responseHandler);
    }

    /**
     * 返回String带参数(https)
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public void httpsPost(String url, Map<String, String> params, AsyncHttpResponseHandler responseHandler) {
        LogUtil.info("Https Post", R.id.http_get, "=============Request Start================");
        if (!TextUtils.isEmpty(url)) {
            LogUtil.error("Https Post", R.id.http_get, "Request Url>>>>>"
                    + UrlUtil.getHttpsApiUrl(formatUrl(UrlUtil.getApiHost(), url)) + legalize(params));
        }
        if (!params.isEmpty()) {
            LogUtil.info("Https Post", R.id.http_get, "Request Params>>>>>" + params.toString());
        }
        LogUtil.info("Https Post", R.id.http_get, "=============Request End================");
        // SSLSocketFactory sf = MySSLSocketFactory.getFixedSocketFactory();
        // SchemeRegistry schReg = new SchemeRegistry();
        // schReg.register(new Scheme("https", sf, 443));
        // AsyncHttpClient https_client = new AsyncHttpClient(schReg);
        // https_client.setSSLSocketFactory(sf);
        asyncHttpClient.post(UrlUtil.getHttpsApiUrl(formatUrl(UrlUtil.getApiHost(), url))
                , legalize(params), responseHandler);
    }

    private String formatUrl(String host, String relativeUrl) {
        StringBuilder sb = new StringBuilder();
        return sb.append(host).append('/').append(UrlUtil.getApiHost()).append('/').append(relativeUrl).append('?').toString();
    }

    /**
     * 关闭请求连接
     *
     * @param c: connection
     */
    public void closeAll(Context c) {
        asyncHttpClient.cancelRequests(c, true);
    }

    public void closeAt(String url, AsyncHttpResponseHandler handler) {
        if (!TextUtils.isEmpty(url))
            asyncHttpClient.delete(url, handler);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        String absoluteUrl = "";
        if (relativeUrl.indexOf(BAES_HTTP_STRING) > -1) {
            absoluteUrl = relativeUrl;
        } else {
            absoluteUrl = BAES_URL + relativeUrl;
        }

        return absoluteUrl;
    }

    public static class UrlUtil {

        public static String getApiHost() {
            String hostUrl = "";
            if (DebugUtil.getDEBUG()) {
                hostUrl = CommonValues.HOST_TEST;
            }
            else{
                hostUrl = CommonValues.HOST_PRODUCT;
            }

            return hostUrl;
        }

//        public static void setApiHost(String api) {
//            PreferenceUtil.setApiHost(api);
//        }
//
//        public static String getApiHost() {
//            return PreferenceUtil.getApiHost();
//        }
//
//        public static void setApiSecurity(String securtiy) {
//            PreferenceUtil.setApiHostSecurity(securtiy);
//        }
//
//        public static String getApiSecurity() {
//            return PreferenceUtil.getApiHostSecurity();
//        }

        private static String getSSLApiRoot(String domain) {
            StringBuilder sb = new StringBuilder("https://");
            return sb.append(domain).append('/').toString();
        }

        public static String getSSLApiUrl(String domain, String url) {
            return getSSLApiRoot(domain) + url;
        }

        private static String getApiRoot(String domain) {
            StringBuilder sb = new StringBuilder("http://");
            return sb.append(domain).toString();
        }

        private static String getWebViewApiRoot(String domain) {
            StringBuilder sb = new StringBuilder("http://");
            return sb.append(domain).toString();
        }

        private static String getHttpsApiRoot(String domain) {
            StringBuilder sb = new StringBuilder("https://");
            return sb.append(domain).toString();
        }

        public static String getWebViewApiRoot(String domain, String url) {
            return getWebViewApiRoot(domain) + url;
        }

        public static String getApiUrl(String domain, String url) {
            return getApiRoot(domain) + url;
        }

        public static String getApiUrl(String url) {
            return getApiRoot(url);
        }

        public static String getHttpsApiUrl(String domain) {
            return getHttpsApiRoot(domain);
        }

        public static String getParamUrl(String domain, String url, String id) {
            StringBuilder sb = new StringBuilder(getApiUrl(domain, url));
            return sb.append('/').append(id).toString();
        }
    }
}

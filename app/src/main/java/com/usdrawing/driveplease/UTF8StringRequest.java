package com.usdrawing.driveplease;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class UTF8StringRequest<T> extends Request<T> {
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;
    private static String session_id = "";

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url      URL of the request to make
     * @param clazz    Relevant class object, for Gson's reflection
     * @param headers  Map of request headers
     * @param listener
     */
    public UTF8StringRequest(String url, Class clazz, Map<String, String> headers,
                             Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    public static String getSession_id() {
        return session_id;
    }

    public static void setSession_id(String session_id) {
        UTF8StringRequest.session_id = session_id;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map headers = new HashMap();
        headers.putAll(super.getHeaders());
        Log.e("JacksonRequest", " -> session_id = " + session_id);
        if (!(session_id.equals(""))) {
            headers.put("Cookie", session_id);
        }
        return headers;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        String utf8String = "";
        if (response != null) {
            try {
                utf8String = new String(response.data, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            for (int i = 0; response.allHeaders != null && i < response.headers.size(); i++) {
                if (response.allHeaders.get(i).getName().startsWith("Set-Cookie")) {
                    String str = response.allHeaders.get(i).getValue();
                    //String[] parts = str.split("\\W{1,}");
                    setSession_id(str);
                    System.out.println(i + ") all " + response.allHeaders.get(i).getName() + " " + response.allHeaders.get(i).getValue());
                }
            }
        }
        return Response.success((T) utf8String, HttpHeaderParser.parseCacheHeaders(response));
    }
}
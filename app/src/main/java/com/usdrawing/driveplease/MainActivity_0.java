package com.usdrawing.driveplease;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainActivity_0 extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://data.gov.il/dataset/618dd157-8df3-43e7-bf9a-00974b4919e9/resource/b5bb714b-b2c8-42ca-bc90-9c235863b1dd/download/theoryexamhe_data.xml";
        // Request a string response from the provided URL.
        UTF8StringRequest jacksonRequest = new UTF8StringRequest( url,String.class,null,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String utf8String="";
                        try {
                            utf8String = new String(response.getBytes("UTF-16LE"),"UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        Log.d("kishkush", utf8String);
                        System.out.println(utf8String);

                        utf8String = utf8String.replaceAll("(\\r|\\n|\\t)", "");
                       /* XmlMapper xmlMapper = new XmlMapper();
                        JacksonXmlModule xmlModule = new JacksonXmlModule();
                        xmlModule.setDefaultUseWrapper(false);
                        xmlMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
                        ExchangeCurrencies er = null;
                        try {
                            er = xmlMapper.readValue(utf8String, ExchangeCurrencies.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/

                        // Display the first 500 characters of the response string.
/*
                        Log.d("er is null ?", (er == null) ? "True" : "False");
                        System.out.println(String.format("%,d", er.getCurrencies().size())+" rates");
                        for (int i = 0; i < ((er.getCurrencies().size() > 100)? 100 : er.getCurrencies().size()); i++) {
                            System.out.println(er.getCurrencies().get(i));
                        }
*/
                        mTextView.setText("Response is: " + utf8String);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work! "+error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(jacksonRequest);
    }
}

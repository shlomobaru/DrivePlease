package com.usdrawing.driveplease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

// https://data.gov.il/dataset/618dd157-8df3-43e7-bf9a-00974b4919e9/resource/b5bb714b-b2c8-42ca-bc90-9c235863b1dd/download/theoryexamhe_data.xml
public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private int[] questionsList;

    public DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.mTextView);

        //Channel myChannel = responseChannle(myChannel);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://data.gov.il/dataset/618dd157-8df3-43e7-bf9a-00974b4919e9/resource/b5bb714b-b2c8-42ca-bc90-9c235863b1dd/download/theoryexamhe_data.xml";
        // Request a string response from the provided URL.
        UTF8StringRequest jacksonRequest = new UTF8StringRequest(url, String.class, null,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        response = response.replaceAll("(\\r|\\n|\\t)", "");

                        JacksonXmlModule xmlModule = new JacksonXmlModule();
                        xmlModule.setDefaultUseWrapper(false);
                        XmlMapper xmlMapper = new XmlMapper(xmlModule);
                        xmlMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

                        Reader reader = new StringReader(response);
                        XMLInputFactory factory = XMLInputFactory.newInstance(); // Or newFactory()
                        XMLStreamReader xmlReader = null;
                        Channel channel = null;
                        try {
                            xmlReader = factory.createXMLStreamReader(reader);
                            xmlReader.next();
                            xmlReader.next();
                            channel = xmlMapper.readValue(xmlReader, Channel.class);

                        } catch (XMLStreamException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                xmlReader.close();
                                reader.close();
                            } catch (XMLStreamException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        mDatabase = FirebaseDatabase.getInstance().getReference("qoestions");
                        Log.e("mDatabase", " mDatabase =  " + mDatabase.getKey().length());
                        for (int i = 0; i < channel.getItems().size(); i++) {
                            String getDescription = channel.getItems().get(i).getDescription();
                            String getAuthor = channel.getItems().get(i).getAuthor();
                            String getCategory = channel.getItems().get(i).getCategory();
                            String getGuid = channel.getItems().get(i).getGuid();
                            String getLink = channel.getItems().get(i).getLink();
                            String getPubDate = channel.getItems().get(i).getPubDate();
                            String getTitle = channel.getItems().get(i).getTitle();
                            mDatabase.child(i+"").child("Description").setValue(getDescription);
                            mDatabase.child(i+"").child("Author").setValue(getAuthor);
                            mDatabase.child(i+"").child("Category").setValue(getCategory);
                            mDatabase.child(i+"").child("Guid").setValue(getGuid);
                            mDatabase.child(i+"").child("Link").setValue(getLink);
                            mDatabase.child(i+"").child("PubDate").setValue(getPubDate);
                            mDatabase.child(i+"").child("Title").setValue(getTitle);
                            mDatabase.child(i+"").child("questionID").setValue(i);

                        }

                        questionsList = testBuilder(channel);
                        Intent intent = new Intent(MainActivity.this, TestActivity.class);
                        intent.putExtra("questionsList", questionsList);
                        startActivity(intent);

                        //mTextView.setText(questionsList.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work! " + error.getMessage());
            }
        });


// Add the request to the RequestQueue.
        queue.add(jacksonRequest);
    }

    public int[] testBuilder(Channel channel) {
        Log.e("testBuilderIs", " Channel items =  " + channel.getItems().toString());
        List<Item> questionHolder = channel.getItems();
        int[] testQuestions = new int[30];
        int max = questionHolder.size();
        Random rand = new Random();
        channelBuilder(channel);

        for (int i = 0; i < 30; i++) {
            int n = rand.nextInt(max);
            System.out.println("n = " + n);
            for (int j = 0; j < 30; j++) {
                if (n == testQuestions[j]) {
                    j = 30;
                } else {
                    testQuestions[i] = n;
                }
                testQuestions[i] = n;
            }

        }
        for (int e = 0; e < 30; e++) {
            System.out.println("question number " + e + ": " + testQuestions[e]);
        }
        return testQuestions;

    }

    private void channelBuilder(Channel channel) {
        Channel newCannel = new Channel();
        newCannel.setItems(channel.getItems());
    }

    private void freshStart(Void aVoid) {
        // DataBase
        mDatabase = FirebaseDatabase.getInstance().getReference("https://driveplease-a8c65.firebaseio.com/");
        String str = mDatabase.getKey();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser fuser = mAuth.getCurrentUser();
        uid = fuser.getUid();
    }
}

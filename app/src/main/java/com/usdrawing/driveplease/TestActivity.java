package com.usdrawing.driveplease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    TextView question;
    Button next;
    int questionNumber = 1;
    public DatabaseReference mDatabase;
    private final int cut = 91;
    private int questionCounter = 0;
    private int[] questionsList = new int[30];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Channel channel = new Channel();

        mDatabase = FirebaseDatabase.getInstance().getReference("qoestions");
        List<Item> allQuestions = new ArrayList();
        allQuestions = channel.getItems();

        question = findViewById(R.id.question);
        next = findViewById(R.id.nextQuestion);
        next.setOnClickListener(this);
        Intent intent = new Intent();
        questionsList = getIntent().getIntArrayExtra("questionsList");

        int currentQuestion = questionsList[questionCounter];
        String questionKey = mDatabase.child("" + questionCounter).child("Description").getKey();
        String questionString = "this is question #" + questionCounter + "  " + questionKey.getBytes().toString();
        question.setText(questionString);
        Log.e("text", " question =  " + question);
        questionCounter++;
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == next.getId()) {
            if (questionCounter == questionsList.length) {
                Toast.makeText(this, "סיימת את המבחן, כל הכבוד", Toast.LENGTH_LONG).show();
                next.setVisibility(View.GONE);

            }
            int currentQuestion = questionsList[questionCounter];
            String questionKey = mDatabase.child("" + questionCounter).child("Description").getKey();
            String questionString = "this is question #" + questionCounter + "  " + questionKey.getBytes().toString();
            question.setText(questionString);
            Log.e("text", " question =  " + question);
            questionCounter++;
            Toast.makeText(this, questionCounter + " שאלה הבאה ", Toast.LENGTH_SHORT).show();

        }

    }
}


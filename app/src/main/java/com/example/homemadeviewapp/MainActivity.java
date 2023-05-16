package com.example.homemadeviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;

import com.example.surveylib.Callback_answersReadyProtocol;
import com.example.surveylib.Question;
import com.example.surveylib.SatisfactionSurvey;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Callback_answersReadyProtocol callback_answersReadyProtocol = new Callback_answersReadyProtocol() {
        @Override
        public void handleResults(ArrayList<Question> questions) {
            //TODO use the result
            Log.d("in callback", "handle results");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout mainActivity = findViewById(R.id.main_LAY_mainactivitylay);

        SatisfactionSurvey.get().setCallback_answersReadyProtocol(callback_answersReadyProtocol);
        SatisfactionSurvey.get().initiateSurvey(this, mainActivity); // Inflates the view of the survey to activity's content view and initializes the adapter with the added questions

    }


}
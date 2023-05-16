package com.example.surveylib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class SatisfactionSurvey {


    /*
     Satisfaction Survey: Basic survey contains 4 questions:
     1.Was the service reliable?"
     2.Was the service professional?
     3.Was the price fair?"
     4.Would you recommend this service?

        ** The library contains a contentProvider which initiates this class **
      + Initialize this module in your Application class/ Content Provider:
            SatisfactionSurvey.initHelper();

          + Open an empty activity to inject the survey.
            In your activity's onCreate method generate the survey:
            SatisfactionSurvey.get().initiateSurvey(this, mainActivity);

            param: this: Sends the activity's context
            param: mainActivity: The Layout of the activity for inject the survey to.

            For example:
             protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main); // An empty xml file of the empty activity.
                ConstraintLayout mainActivity = findViewById(R.id.main_LAY_mainactivitylay); // The layout of this xml file when the R.id.main_LAY_mainactivitylay is the id was given to the layout
             }

          + To notify your activity when results was submitted and handle results add callback to your activity:
           Callback_answersReadyProtocol callback_answersReadyProtocol = new Callback_answersReadyProtocol() {
                @Override
                public void handleResults(ArrayList<Question> questions) {
                    //handle results
                }
           };
           + In the callback, you can get the questions and the answers:
           questions.get(some_index).getQuestion() // To get the question String
           questions.get(some_index).getAnswer() // To get the answer (between 0-3)

           + To use the callback function to handle results, in the OnCreate function of the activity set the callback:
           SatisfactionSurvey.get().setCallback_answersReadyProtocol(callback_answersReadyProtocol);

     */

    private static SatisfactionSurvey instance;
    private ArrayList<Question> allQuestions = new ArrayList<>();
    private RecyclerView survey_LST_questions;
    private ExtendedFloatingActionButton survey_BTN_submit;

    private Callback_answersReadyProtocol callback_answersReadyProtocol;
    QuestionAdapter questionAdapter;


    public static SatisfactionSurvey get(){
        return instance;
    }

    public static SatisfactionSurvey initHelper(){
        if(instance == null)
            instance = new SatisfactionSurvey();
        return instance;
    }

    public void setCallback_answersReadyProtocol(Callback_answersReadyProtocol callback_answersReadyProtocol){
        this.callback_answersReadyProtocol = callback_answersReadyProtocol;
    }

    private void initBasicQuestions(){
        allQuestions.add(new Question().setQuestion("Was the service reliable?"));
        allQuestions.add(new Question().setQuestion("Was the service professional?"));
        allQuestions.add(new Question().setQuestion("Was the price fair?"));
        allQuestions.add(new Question().setQuestion("Would you recommend this service?"));
    }


    public void initiateSurvey(Context context, ConstraintLayout mainLay){
        initBasicQuestions();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.satisfaction_survey, null);
        findViews(rootView);

        survey_BTN_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback_answersReadyProtocol.handleResults(allQuestions);

            }
        });
        mainLay.addView(rootView);

        questionAdapter = new QuestionAdapter(context, allQuestions);
       // questionAdapter.setCallBack_openPageProtocol(callBack_openPageProtocol);
        survey_LST_questions.setLayoutManager(new LinearLayoutManager(context));
        survey_LST_questions.setAdapter(questionAdapter);
    }

    private void findViews(View rootView){
        survey_LST_questions = rootView.findViewById(R.id.survey_LST_questions);
        survey_BTN_submit = rootView.findViewById(R.id.survey_BTN_submit);

    }


}

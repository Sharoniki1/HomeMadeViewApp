package com.example.surveylib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private ArrayList<Question> questions;


    public QuestionAdapter(Context context, ArrayList<Question> questions){
        this.context = context;
        this.questions = questions;
    }


    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list, parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(view);

        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.question_LBL_question.setText(question.getQuestion());
//        if(question.getAnswer() != -1){
//            holder.question_BAR_custombar[question.getAnswer()].setTextColor(Color.BLACK);// TODO change color to black and bold
//           holder.question_BAR_custombar[question.getAnswer()].setTypeface(null, Typeface.BOLD);
//        }
//        //else
//        else{
//            for(int i=0; i<holder.question_BAR_custombar.length; i++)
//            {
//                holder.question_BAR_custombar[i].setTextColor(Color.WHITE);//TODO change color to white and unbold
//                holder.question_BAR_custombar[i].setTypeface(null, Typeface.NORMAL);
//            }
//
//        }

        for(int i=0; i<holder.question_BAR_custombar.length;i++){
            int finalI = i;
            holder.question_BAR_custombar[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("answer clicked number: ", finalI+"" );
                    if(question.getAnswer()!= -1){
                        Log.d("answer is not -1. its: ", question.getAnswer()+"");
                        holder.question_BAR_custombar[question.getAnswer()].setTextColor(Color.WHITE);// TODO change color to white and unbold
                        holder.question_BAR_custombar[question.getAnswer()].setTypeface(null, Typeface.NORMAL);
                    }
                        //holder.question_BAR_custombar[question.getAnswer()].set
                    //holder.question_BAR_custombar[finalI].setPressed(true);
                    //addAnswer(finalI);
                    question.setAnswer(finalI);
                    holder.question_BAR_custombar[finalI].setTextColor(Color.BLACK);// TODO change color to black and bold
                    holder.question_BAR_custombar[finalI].setTypeface(null, Typeface.BOLD);

                }
            });
        }

    }

    private void addAnswer(int finalI) {
        questions.get(finalI).setAnswer(finalI);
    }

    @Override
    public int getItemCount() {
        return questions == null ? 0: questions.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView question_LBL_question;
        private MaterialButton[] question_BAR_custombar;


        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            findViews(itemView);
        }

        private void findViews(View itemView) {

            question_LBL_question= itemView.findViewById(R.id.question_LBL_question);
            question_BAR_custombar = new MaterialButton[]{

                    itemView.findViewById(R.id.question_BTN_notatallbtn),
                    itemView.findViewById(R.id.question_BTN_insomelevel),
                    itemView.findViewById(R.id.question_BTN_mostlyyes),
                    itemView.findViewById(R.id.question_BTN_perfect)
            };


        }
    }



}

package com.example.surveylib;

public class Question {

    private String question;
    private int answer = -1;

    public Question(){}

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public int getAnswer() {
        return answer;
    }

    public Question setAnswer(int answer) {
        this.answer = answer;
        return this;
    }
}

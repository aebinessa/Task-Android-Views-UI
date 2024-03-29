package com.binjesus.codedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, textViewResult;
    private Button trueButton , falseButton, nextQuestionButton;




    private int currentQuestionsIndex = 0;


    private final ArrayList<String> questions = new ArrayList<>();
    private final ArrayList<Boolean> answers = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions.add("Does java suck?");
        questions.add("does IOS rock?");
        questions.add("is it winter in kuwait");

        answers.add(true);
        answers.add(true);
        answers.add(true);
        currentQuestionsIndex = 0;



        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        textViewResult = findViewById(R.id.textViewResult);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        nextQuestionButton.setVisibility(View.INVISIBLE);
        updateQuestion();
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                nextQuestionButton.setVisibility(View.VISIBLE);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                nextQuestionButton.setVisibility(View.INVISIBLE);

            }
        });


        updateQuestion();


    }




    private void updateQuestion() {

        if (currentQuestionsIndex < questions.size()) {
            questionTextView.setText(questions.get(currentQuestionsIndex));
        } else questionTextView.setText("finished");

    }

    private void checkAnswer(boolean answer){
        if(answers.get(currentQuestionsIndex) == answer) {
textViewResult.setText("correct");
            currentQuestionsIndex++;
            updateQuestion();
        } else{
            textViewResult.setText("wrong");

        }

    }

}
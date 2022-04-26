package com.nguyenvanhailong.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button A,B,C,D;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        submitBtn = findViewById(R.id.submit_btn);

        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        loadNewQuestion();




    }

    @Override
    public void onClick(View view) {

        A.setBackgroundColor(Color.WHITE);
        B.setBackgroundColor(Color.WHITE);
        C.setBackgroundColor(Color.WHITE);
        D.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.answers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        totalQuestionsTextView.setText("Câu hỏi hiện tại: "+(int)(currentQuestionIndex+1)+"/"+totalQuestion);
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        C.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        D.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Bài làm khá tốt";
        }else{
            passStatus = "Bài làm tệ!";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Điểm số của bạn "+ score+"/"+ totalQuestion)
                .setPositiveButton("Làm lại",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}
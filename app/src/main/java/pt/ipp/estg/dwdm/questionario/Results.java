package pt.ipp.estg.dwdm.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    public static final String MESSAGE_RESULT1 = "Parabéns!";
    public static final String MESSAGE_RESULT2 = "Quase lá!";
    public static final String MESSAGE_RESULT3 = "Pratique mais!";
    public static final String MESSAGE_RESULT4 = "Tente novamente!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        int correctAnswers = 0;

        String qOneResult = intent.getStringExtra(Quiz.answer1Result);
        String qTwoResult = intent.getStringExtra(Quiz.answer2Result);
        String qThreeResult = intent.getStringExtra(Quiz.answer3Result);

        if (qOneResult.equals("Correto")) {
            correctAnswers++;
        }

        if (qTwoResult.equals("Correto")) {
            correctAnswers++;
        }

        if (qThreeResult.equals("Correto")) {
            correctAnswers++;
        }


        TextView q1 = (TextView) findViewById(R.id.result_q1);
        TextView q2 = (TextView) findViewById(R.id.result_q2);
        TextView q3 = (TextView) findViewById(R.id.result_q3);

        q1.setText(qOneResult);
        q2.setText(qTwoResult);
        q3.setText(qThreeResult);

        TextView result = (TextView) findViewById(R.id.final_result);

        if (correctAnswers == 3) {
            result.setText(MESSAGE_RESULT1);
        } else if (correctAnswers == 2) {
            result.setText(MESSAGE_RESULT2);
        } else if (correctAnswers == 1) {
            result.setText(MESSAGE_RESULT3);
        } else {
            result.setText(MESSAGE_RESULT4);
        }


    }
}
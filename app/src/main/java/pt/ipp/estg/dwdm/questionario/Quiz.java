package pt.ipp.estg.dwdm.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    public static final String answer1Result = "ANSWER_1_RESULT";
    public static final String answer2Result = "ANSWER_2_RESULT";
    public static final String answer3Result = "ANSWER_3_RESULT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView fNumberQ1 = (TextView) findViewById(R.id.number1_q1);
        TextView sNumberQ1 = (TextView) findViewById(R.id.number2_q1);
        TextView fNumberQ2 = (TextView) findViewById(R.id.number1_q2);
        TextView sNumberQ2 = (TextView) findViewById(R.id.number2_q2);
        TextView fNumberQ3 = (TextView) findViewById(R.id.number1_q3);
        TextView sNumberQ3 = (TextView) findViewById(R.id.number2_q3);


        String fnQ1 = randomNr();
        String snQ1 = randomNr();

        String fnQ2 = randomNr();
        String snQ2 = randomNr();

        if (Integer.parseInt(snQ2) > Integer.parseInt(fnQ2)) {
            String aux;
            aux = snQ2;
            snQ2 = fnQ2;
            fnQ2 = aux;
        }
        String fnQ3 = randomNr();
        String snQ3 = randomNr();

        fNumberQ1.setText(fnQ1);
        sNumberQ1.setText(snQ1);
        fNumberQ2.setText(fnQ2);
        sNumberQ2.setText(snQ2);
        fNumberQ3.setText(fnQ3);
        sNumberQ3.setText(snQ3);


    }

    public String randomNr() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int result = 0;

        for (int i = 0; i < max; i++) {
            result = (int) (Math.random() * range) + min;
        }

        return Integer.toString(result);

    }


    public void submitAnswers(View view) {
        EditText answer1 = (EditText) findViewById(R.id.answer_q1);
        EditText answer2 = (EditText) findViewById(R.id.answer_q2);
        EditText answer3 = (EditText) findViewById(R.id.answer_q3);

        if (answer1.getText().toString().isEmpty() || answer2.getText().toString().isEmpty() || answer3.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(this, R.string.warning_message1, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Intent intent = new Intent(this, Results.class);
        int a1 = Integer.parseInt(answer1.getText().toString());
        int a2 = Integer.parseInt(answer2.getText().toString());
        int a3 = Integer.parseInt(answer3.getText().toString());

        String[] results = verfAnswers(a1, a2, a3);
        intent.putExtra(answer1Result, results[0]);
        intent.putExtra(answer2Result, results[1]);
        intent.putExtra(answer3Result, results[2]);
        startActivity(intent);


    }

    private String[] verfAnswers(int a1, int a2, int a3) {
        String[] results = new String[3];
        TextView fNumberQ1 = (TextView) findViewById(R.id.number1_q1);
        TextView sNumberQ1 = (TextView) findViewById(R.id.number2_q1);
        TextView fNumberQ2 = (TextView) findViewById(R.id.number1_q2);
        TextView sNumberQ2 = (TextView) findViewById(R.id.number2_q2);
        TextView fNumberQ3 = (TextView) findViewById(R.id.number1_q3);
        TextView sNumberQ3 = (TextView) findViewById(R.id.number2_q3);

        int fnQ1 = Integer.parseInt(fNumberQ1.getText().toString());
        int snQ1 = Integer.parseInt(sNumberQ1.getText().toString());

        if ((fnQ1 + snQ1) == a1) {
            results[0] = "Correto";
        } else {
            results[0] = "Incorreto";
        }

        int fnQ2 = Integer.parseInt(fNumberQ2.getText().toString());
        int snQ2 = Integer.parseInt(sNumberQ2.getText().toString());

        if ((fnQ2 - snQ2) == a2) {
            results[1] = "Correto";
        } else {
            results[1] = "Incorreto";
        }

        int fnQ3 = Integer.parseInt(fNumberQ3.getText().toString());
        int snQ3 = Integer.parseInt(sNumberQ3.getText().toString());

        if ((fnQ3 * snQ3) == a3) {
            results[2] = "Correto";
        } else {
            results[2] = "Incorreto";
        }

        return results;
    }


}
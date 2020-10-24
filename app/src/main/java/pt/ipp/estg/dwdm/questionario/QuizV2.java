package pt.ipp.estg.dwdm.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizV2 extends AppCompatActivity {
    private String op = randomOperator();
    private String nrOne = randomNr();
    private String nrTwo = randomNr();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_v2);
        TextView operation = (TextView) findViewById(R.id.operation);

        if(op.equals("-") && (Integer.parseInt(nrTwo) > Integer.parseInt(nrOne))) {
            String aux;
            aux = nrOne;
            nrOne = nrTwo;
            nrTwo = aux;
        }
        operation.setText(nrOne + "   " + op + "   " + nrTwo + "   " + "="+"   " + "X");

    }

    public void checkAnswer(View view) {
        EditText answer = (EditText) findViewById(R.id.editTextNumber);

        if (answer.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(this, R.string.warning_message2, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        int userAnswer = Integer.parseInt(answer.getText().toString());
        int correctAnswer = operation(Integer.parseInt(nrOne), Integer.parseInt(nrTwo), op);
        TextView rMessage = (TextView) findViewById(R.id.result_message);
        String resultMessage = "Tente novamente";

         if (userAnswer == correctAnswer) {
             resultMessage = "Resultado correto!";
         }

         rMessage.setText(resultMessage);

    }


    public String randomNr() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int result = 0;

        for(int i = 0; i < max; i++) {
            result = (int)(Math.random() * range) + min;
        }

        return Integer.toString(result);

    }


    public String randomOperator() {
        int max = 45;
        int min = 42;
        int range = max - min + 1;
        char result = ' ';

        for(int i = 42; i < max; i++) {
            result = (char) ((int)(Math.random() * range) + min);
        }

        if (result == ',') return randomOperator();

        if (result == '*') result = 'x';

        return Character.toString(result);
    }

    public int operation (int nrOne, int nrTwo, String operator) {
        int result = 0;

        if (operator.equals("+")) result = nrOne + nrTwo;

        if (operator.equals("-")) result = nrOne - nrTwo;

        if (operator.equals("x")) result = nrOne * nrTwo;

        return result;
    }



}
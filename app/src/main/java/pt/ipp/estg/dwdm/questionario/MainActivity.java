package pt.ipp.estg.dwdm.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuizVOne (View view) {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void startQuizVTwo(View view) {
      Intent intent = new Intent(this, QuizV2.class);
      startActivity(intent);
    }
}
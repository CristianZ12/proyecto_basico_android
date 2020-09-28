package amoungus.impostor.amoungus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        button();
    }

    private void button(){
        Button btnSalir = (Button) findViewById(R.id.btn_salir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    private void salir(){
        Intent salir1 = new Intent(this, RegisterActivity.class);
        startActivity(salir1);
    }
}
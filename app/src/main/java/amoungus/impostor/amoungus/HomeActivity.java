package amoungus.impostor.amoungus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        textRegister();
        logOut();
    }

    private void textRegister(){
        TextView txt_msg = (TextView) findViewById(R.id.text_test);
        Bundle mrElegant = this.getIntent().getExtras();

        if(mrElegant != null){
            String name = mrElegant.getString("Nombre");
            String apellido = mrElegant.getString("Apellido");
            String email = mrElegant.getString("Email");
            txt_msg.setText("Welcome " + name + " " + apellido + " This is your email: " + email);
        }
    }

    private void logOut(){
        Button logOut1 = (Button) findViewById(R.id.btn_logOut);
        logOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register(){
        Intent register1 = new Intent(this, RegisterActivity.class);
        startActivity(register1);
    }
}
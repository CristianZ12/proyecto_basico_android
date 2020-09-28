package amoungus.impostor.amoungus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    //Variables
    private String name1 = "";
    private String lastName = "";
    private String password = "";
    private String repeatPassword = "";
    private String email = "";
    private String setMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        btn_Register();
        btn_dudas();
    }

    private void btn_Register(){
        //Value of Button
        Button btn_registrar = (Button) findViewById(R.id.btn_register);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void btn_dudas(){
        Button btn_dudas1 = (Button) findViewById(R.id.btn_dudas);
        btn_dudas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dudas();
            }
        });
    }

    private void dudas(){
        Intent dudas1 = new Intent(this, QuestionActivity.class);
        startActivity(dudas1);
    }

    private void validation(){
        //Value of Edit Text
        EditText name = (EditText) findViewById(R.id.name_input);
        EditText apellido = (EditText) findViewById(R.id.last_name_input);
        EditText pwr = (EditText) findViewById(R.id.pwr_input);
        EditText rptpwr = (EditText) findViewById(R.id.rpt_pwr_input);
        EditText email2 = (EditText) findViewById(R.id.email_input);

        //Value of Text View
        TextView message = (TextView) findViewById(R.id.message_register);

        name1 = name.getText().toString();
        lastName = apellido.getText().toString();
        password = pwr.getText().toString();
        repeatPassword = rptpwr.getText().toString();
        email = email2.getText().toString();

        if(name1.equals("")){
            setMessage = "Por favor ingrse su nombre.";
            message.setText(setMessage);
        } else if(lastName.equals("")){
            setMessage = "Por favor ingrese su apellido.";
            message.setText(setMessage);
        } else if(email.equals("")){
            setMessage = "Por favor ingrese su email.";
            message.setText(setMessage);
        } else if(password.equals("")){
            setMessage = "Por favor ingrese su contraseña.";
            message.setText(setMessage);
        } else if(repeatPassword.equals("")) {
            setMessage = "Por favor repita su contraseña.";
            message.setText(setMessage);
        } else if(!repeatPassword.equals(password)){
            setMessage = "Contraseña erronea corrija repetir contraseña.";
            message.setText(setMessage);
        } else if(!name1.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("") && !repeatPassword.equals("") && repeatPassword.equals(password)){
            setMessage = "Welcome " + name1 + " " + lastName;
            bundleActivity(name1, lastName, email, setMessage);
        }
    }

    private void bundleActivity(String name, String lastName, String email, String message){
        Toast msgToast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        msgToast.setGravity(Gravity.CENTER, 0, 0);
        msgToast.show();

        Intent homeAct = new Intent(this, HomeActivity.class);

        Bundle mrElegant = new Bundle();
        mrElegant.putString("Nombre", name);
        mrElegant.putString("Apellido", lastName);
        mrElegant.putString("Email", email);
        homeAct.putExtras(mrElegant);
        startActivity(homeAct);
    }

}
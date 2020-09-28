package amoungus.impostor.amoungus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSetup();
        dataApp();
    }

    private void startSetup(){
        Button start = (Button) findViewById(R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register(){
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

    private void dataApp(){
        String name = "Amoung Us App";
        String version = "";
        version = BuildConfig.VERSION_NAME;
        TextView nameApp = (TextView) findViewById(R.id.nameApp);
        TextView versionApp = (TextView) findViewById(R.id.versionApp);
        nameApp.setText(name);
        versionApp.setText(version);
    }
}
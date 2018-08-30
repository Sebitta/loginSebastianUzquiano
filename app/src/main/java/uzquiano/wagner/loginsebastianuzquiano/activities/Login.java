package uzquiano.wagner.loginsebastianuzquiano.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import uzquiano.wagner.loginsebastianuzquiano.R;

public class Login extends AppCompatActivity {
    private Button btn;
    private final String Saludo = "Hola venito camela";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn = (Button) findViewById(R.id.buttonConfirmar);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra("sl2", Saludo);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "Clieck en siguiente", Toast.LENGTH_SHORT).show();

            }
        });
    }
    }

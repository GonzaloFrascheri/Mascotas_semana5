package com.gonzalo.mascotas5.activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.JavaMailer.SendMail;

public class ContactoActivity extends AppCompatActivity {

    EditText nombre;
    EditText correo;
    EditText mensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = findViewById(R.id.etNombre);
        correo = findViewById(R.id.etCorreo);
        mensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
                sendMessage();
        });
    }

    private void sendMessage(){
        String email = correo.getText().toString().trim();
        String nombreUser = nombre.getText().toString().trim();
        String subject = "Desde android " + nombreUser;
        String message = mensaje.getText().toString().trim();
        SendMail sm = new SendMail(this, email, subject, message);
        sm.execute();
    }
}
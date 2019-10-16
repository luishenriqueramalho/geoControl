package com.example.geocontrol.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geocontrol.R;
import com.example.geocontrol.config.ConfiguracaoFirebase;
import com.example.geocontrol.helper.Permissao;
import com.example.geocontrol.helper.Preferencias;
import com.example.geocontrol.model.Usuario;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email       = (EditText) findViewById(R.id.edit_email);
        senha       = (EditText) findViewById(R.id.edit_senha);
        botaoEntrar = (Button) findViewById(R.id.btn_logar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuario = new Usuario();
                usuario.setEmail( email.getText().toString() );
                usuario.setSenha( senha.getText().toString() );
                validarLogin();

            }
        });

    }

    private void validarLogin() {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword( usuario.getEmail(), usuario.getSenha() ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if ( task.isSuccessful() ) {

                    abrirTelaPrincipal();
                    Toast.makeText(LoginActivity.this, "Sucesso ao fazer login!", Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(LoginActivity.this, "Falha ao fazer login!", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void abrirCadastroUsuario(View view) {

        Intent intent = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
        startActivity( intent );

    }
}
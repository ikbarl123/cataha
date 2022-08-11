package com.alimuntung.cataha.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alimuntung.cataha.MainActivity;
import com.alimuntung.cataha.Presenter.AppActivity;
import com.alimuntung.cataha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText edtEmail,edtPassword,edtConPass;
    private ProgressBar progressBar;// 101.192.60
    private FirebaseAuth auth;// 101.192.60
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();// 101.192.60
        getSupportActionBar().hide();// 101.192.60
        setContentView(R.layout.activity_register);
        edtEmail = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);// 101.192.60
        edtConPass = findViewById(R.id.password_confirmation);
        btnRegister = (Button) findViewById(R.id.btn_page_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String conpass = edtConPass.getText().toString().trim();
                if (TextUtils.isEmpty((email))){
                    Toast.makeText(RegisterActivity.this,"Silahkan Isi Email",Toast.LENGTH_SHORT ).show();
                }

                // Ikbar Laudza Alviansyah
// IF-7
// 10119260
                if (TextUtils.isEmpty((password))){
                    Toast.makeText(RegisterActivity.this,"Silahkan isi password",Toast.LENGTH_SHORT ).show();
                }
                if (password.length()<6){
                    Toast.makeText(RegisterActivity.this,"Password Minimal 6 Character",Toast.LENGTH_SHORT ).show();
                }
                if (TextUtils.isEmpty((conpass))){
                    Toast.makeText(RegisterActivity.this,"Silahkan Isi konfirmasi password",Toast.LENGTH_SHORT ).show();
                }
                if (!password.equals(conpass)){
                    Toast.makeText(RegisterActivity.this,"Password tidak sama",Toast.LENGTH_SHORT ).show();
                }
                else {
                //    progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this,"Register Sukses",Toast.LENGTH_SHORT ).show();
                                    Intent home=new Intent(RegisterActivity.this, AppActivity.class);
                                    startActivity(home);
                                }
                                else {

                                }
                            }
                        });
            }}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //       progressBar.setVisibility(View.GONE);
    }
}
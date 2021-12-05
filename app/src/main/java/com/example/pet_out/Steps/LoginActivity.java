package com.example.pet_out.Steps;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pet_out.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email, password;
    Button singing, signup;
    SignInButton signInButton;
    //Google Sign In
    GoogleSignInClient googleSignInClient;
    //Firebase
    FirebaseAnalytics analytics;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        startAnalytics();
        setup();
        events();
    }

    private void events() {
        singing.setOnClickListener(v->{
            //Validate
            if (email.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this,"Por favor ingrese datos", Toast.LENGTH_SHORT).show();
            }else{

                singingWithEmailPassword(email.getText().toString(), password.getText().toString());
            }

        });
        signup.setOnClickListener(v->{
            Intent signup = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(signup );
        });
        signInButton.setOnClickListener(v->{
            if (email.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this,"Por favor ingrese datos", Toast.LENGTH_SHORT).show();
            }else {
                createWithEmailPassword(email.getText().toString(), password.getText().toString());
                //Intent signIn = googleSignInClient.getSignInIntent();
                //startActivityForResult(signIn, 200);
            }
        });
    }

    private void createWithEmailPassword(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if(task.isSuccessful()){
                        FirebaseUser user = auth.getCurrentUser();
                        Toast.makeText(LoginActivity.this, user.getEmail(), Toast.LENGTH_LONG).show();
                        //Validate el email
                        sendEmailVerification(user);
                    }else{
                        Toast.makeText(LoginActivity.this,"Ocurrio un error :c en la creacion de usuario",Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void sendEmailVerification(FirebaseUser user) {
        user.sendEmailVerification().addOnCompleteListener(this, task -> {
            if(task.isSuccessful())
                Toast.makeText(LoginActivity.this,"Verifique su correo", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(LoginActivity.this,"Error al enviar el correo", Toast.LENGTH_LONG).show();
        });
    }

    private void sendEmailLink(String email) {
        ActionCodeSettings settings = ActionCodeSettings.newBuilder()
                .setUrl(getString(R.string.url_mi_mascota))
                .setHandleCodeInApp(true)
                .setAndroidPackageName("com.example.pet_out",true, "24")
                .build();
        auth.sendSignInLinkToEmail(email,settings)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful())
                        Toast.makeText(LoginActivity.this,"Se envio un correo de autenticacion...",Toast.LENGTH_LONG).show();
                    else{
                        Toast.makeText(LoginActivity.this,"Intentando nuevamente!!",Toast.LENGTH_LONG).show();
                        sendEmailLink(email);
                    }

                });
    }

    private void singingWithEmailPassword(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Usuario o Contrasena incorrectas",Toast.LENGTH_LONG).show();
                        return;
                    }
                   FirebaseUser user = auth.getCurrentUser();
                    if(!user.isEmailVerified()){
                        sendEmailVerification(user);
                        Toast.makeText(LoginActivity.this,"Verifique el correo electronico\nCarpeta SPAM",Toast.LENGTH_LONG).show();
                        return;
                    }

                    navigateToMain();
                });
    }

    private void navigateToMain() {
        Intent main = new Intent(this, MenuActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(main);
        finish();
    }

    private void setup() {
        auth = FirebaseAuth.getInstance();
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("224727463605-ns1hppagheis0n2fs6d2n74fle9eoj1c.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, options);
    }
    private void init(){
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        singing = findViewById(R.id.singin_login);
        signup = findViewById(R.id.signup_login);
        signInButton = findViewById(R.id.singGoogleBnt);
    }
    private void startAnalytics() {
        analytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.METHOD, "Basico");
        analytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Validar si ya inicio sesion el usuario


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200){
            Task<GoogleSignInAccount> accountTask =
                    GoogleSignIn.getSignedInAccountFromIntent(data).addOnCompleteListener(task -> {
                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Error al iniciar sesion con Google",Toast.LENGTH_LONG).show();
                            return;
                        }
                        getFirebaseUserWithIdToken(task.getResult().getIdToken());
                    });

        }
    }

    private void getFirebaseUserWithIdToken(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Error al iniciar sesion con Google Auth", Toast.LENGTH_LONG).show();
                        return;
                    }
                    FirebaseUser user = auth.getCurrentUser();
                    navigateToMain();
                });
    }
}
package com.example.planetmedia.login.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.planetmedia.login.Interfaces.LoginPresenter;
import com.example.planetmedia.login.Interfaces.LoginView;
import com.example.planetmedia.login.Presenters.LoginPresentersImpl;
import com.example.planetmedia.login.R;

public class Login extends AppCompatActivity implements LoginView{
    private EditText user,pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user=(EditText)findViewById(R.id.etNombre);
        pass=(EditText) findViewById(R.id.edPassword);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        presenter=new LoginPresentersImpl(this);
    }

    @Override
    public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
    progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
    user.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPassword() {
    pass.setError("Contraseña incorrecta");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(Login.this,PrincipalMenu.class));

    }

    public void validacion(View v){
        presenter.validarUsiario(user.getText().toString(),pass.getText().toString());
    }
}
